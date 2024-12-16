package com.feature.profile.impl.data.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.net.Uri
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.support.v4.media.session.MediaSessionCompat
import android.util.Log
import androidx.core.app.NotificationCompat
import com.core.util.compose.ext.FileExt.toUri
import com.core.util.compose.file.Music
import com.vkClient.feature.profile.impl.R
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MusicService : Service() {

    private val scope: CoroutineScope = CoroutineScope(Job() + Dispatchers.Main)

    private var musics: List<Music> = emptyList()

    private val currentMusic = MutableStateFlow(Music.default())
    private val maxDuration = MutableStateFlow(0f)
    private val currentDuration = MutableStateFlow(0f)
    private val isPlaying = MutableStateFlow(false)

    private var mediaPlayer = MediaPlayer()

    private var job: Job? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            PREV_ACTION -> playPrevMusic()
            NEXT_ACTION -> playNextMusic()
            PAUSE_ACTION -> playPause()
            else -> {
                val startMusic = musics[0]
                playMusic(startMusic)
            }
        }
        return START_STICKY
    }

    private fun playMusic(music: Music) {
        mediaPlayer.reset()
        mediaPlayer = MediaPlayer()
        putDataAndStartPlayer(music)
    }

    fun playPrevMusic() {
        job?.cancel()
        mediaPlayer.reset()

        mediaPlayer = MediaPlayer()

        val index = musics.indexOf(currentMusic.value)
        val prevIndex = if (index < 0) musics.size.minus(1) else index.minus(1)
        val prevItem = musics[prevIndex]

        putDataAndStartPlayer(prevItem)
    }

    fun playNextMusic() {
        job?.cancel()
        mediaPlayer.reset()

        mediaPlayer = MediaPlayer()

        val index = musics.indexOf(currentMusic.value)
        val nextIndex = index.plus(1).mod(musics.size)
        val nextItem = musics[nextIndex]

        putDataAndStartPlayer(nextItem)
    }

    fun playPause() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        } else {
            if (currentMusic.value != Music.default()) {
                putDataAndStartPlayer(currentMusic.value)
            } else {
                putDataAndStartPlayer(musics[0])
            }
        }
        sendNotification(currentMusic.value)
    }

    private fun updateDuration() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.e("TEST1", "Failed updateDuration: ${throwable.localizedMessage}")
        }
        job = scope.launch(coroutineExceptionHandler) {
            if (mediaPlayer.isPlaying.not()) return@launch
            maxDuration.update { mediaPlayer.duration.toFloat() }

            while (true) {
                currentDuration.update { mediaPlayer.currentPosition.toFloat() }
                delay(UPDATE_DURATION_MILLS)
            }
        }
    }

    private fun putDataAndStartPlayer(changeMusic: Music) {
        currentMusic.update { changeMusic }
        try {
            mediaPlayer.setDataSource(this, getUriFromPath(currentMusic.value.path))
            mediaPlayer.prepareAsync()
            mediaPlayer.setOnPreparedListener {
                it.start()
                sendNotification(currentMusic.value)
                updateDuration()
            }
        } catch (e: Exception) {
            Log.e("TEST1", "Failed putDataAndStartPlayer: ${e.localizedMessage}")
        }
    }

    private fun sendNotification(music: Music) {
        isPlaying.tryEmit(mediaPlayer.isPlaying)

        val session = MediaSessionCompat(this, MEDIA_SESSION_TAG)
        val style = androidx.media.app.NotificationCompat.MediaStyle()
            .setShowActionsInCompactView(0, 1, 2)
            .setMediaSession(session.sessionToken)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Music Player Notifications",
                NotificationManager.IMPORTANCE_LOW
            )
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setStyle(style)
            .setContentTitle(music.title)
            .setContentText(music.artist)
            .addAction(
                R.drawable.ic_arrow_back_player,
                PREV_TITLE,
                createActionPendingIntent(PREV_ACTION, 0)
            )
            .addAction(
                if (mediaPlayer.isPlaying) R.drawable.ic_pause else R.drawable.ic_play,
                PAUSE_TITLE,
                createActionPendingIntent(PAUSE_ACTION, 1)
            )
            .addAction(
                R.drawable.ic_arrow_forward_player,
                NEXT_TITLE,
                createActionPendingIntent(NEXT_ACTION, 2)
            )
            .setSmallIcon(R.drawable.ic_music)
            .setLargeIcon(music.pictureUri?.let { file ->
                if (file.exists()) {
                    BitmapFactory.decodeFile(file.toUri(this).toString())
                } else null
            })
            .build()

        startForeground(1, notification)
    }

    override fun onBind(p0: Intent?): IBinder {
        return MusicBinder()
    }

    override fun onDestroy() {
        mediaPlayer.reset()
        job?.cancel()
    }

    private fun getUriFromPath(path: String) = Uri.parse(path)

    private fun createActionPendingIntent(action: String, requestCode: Int): PendingIntent {
        val intent = Intent(this, MusicService::class.java).apply {
            this.action = action
        }
        return PendingIntent.getService(
            this,
            requestCode,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
    }

    inner class MusicBinder : Binder() {

        fun setMusics(musics: List<Music>) {
            this@MusicService.musics = musics
        }

        fun currentMusic() = this@MusicService.currentMusic.asStateFlow()

        fun currentDuration() = this@MusicService.currentDuration.asStateFlow()

        fun maxDuration() = this@MusicService.maxDuration.asStateFlow()

        fun isPlaying() = this@MusicService.isPlaying.asStateFlow()

        fun getService() = this@MusicService

    }

    private companion object {
        const val CHANNEL_ID = "channel_id"
        const val MEDIA_SESSION_TAG = "media_session_tag"
        const val PREV_ACTION = "Prev"
        const val PAUSE_ACTION = "Pause"
        const val NEXT_ACTION = "Next"
        const val PREV_TITLE = "prev"
        const val PAUSE_TITLE = "pause"
        const val NEXT_TITLE = "next"
        const val UPDATE_DURATION_MILLS = 1000L
    }
}