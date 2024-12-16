package com.feature.profile.impl.data.repository

import android.app.Application
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import com.core.network.di.DefaultScope
import com.core.util.compose.file.Music
import com.feature.profile.impl.data.service.MusicService
import com.feature.profile.impl.doman.repository.IMusicRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class MusicRepository @Inject constructor(
    private val context: Application,
    @DefaultScope private val scope: CoroutineScope,
) : IMusicRepository {

    private var connection: ServiceConnection? = null
    private var musicService: MusicService? = null

    private val currentMusic = MutableStateFlow(Music.default())
    private val maxDuration = MutableStateFlow(0f)
    private val currentDuration = MutableStateFlow(0f)
    private val isPlaying = MutableStateFlow(false)

    private var job: Job? = null

    override fun bindMusicService() {
        connection = object : ServiceConnection {
            override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
                val binder = (service as? MusicService.MusicBinder) ?: return
                musicService = binder.getService()

                job = combine(
                    binder.currentMusic(),
                    binder.currentDuration(),
                    binder.maxDuration(),
                    binder.isPlaying(),
                ) { serviceCurrentMusic, serviceCurrentDuration, serviceMaxDuration, serviceIsPlaying ->
                    currentMusic.update { serviceCurrentMusic }
                    maxDuration.update { serviceMaxDuration }
                    currentDuration.update { serviceCurrentDuration }
                    isPlaying.update { serviceIsPlaying }
                }.launchIn(scope)
            }

            override fun onServiceDisconnected(p0: ComponentName?) {
                connection = null
                job?.cancel()
            }
        }

        connection?.run {
            context.bindService(
                Intent(context, MusicService::class.java),
                this,
                Context.BIND_AUTO_CREATE
            )
        }
    }

    override fun playPause(musics: List<Music>) {
        musicService?.MusicBinder()?.setMusics(musics)
        musicService?.playPause()
    }

    override fun unBindService() {
        connection?.run {
            context.unbindService(this)
            connection = null
            job?.cancel()
        }
    }

    override fun currentMusic(): StateFlow<Music> = currentMusic.asStateFlow()

    override fun currentDuration(): StateFlow<Float> = currentDuration.asStateFlow()

    override fun maxDuration(): StateFlow<Float> = maxDuration.asStateFlow()

    override fun isPlaying(): StateFlow<Boolean> = isPlaying.asStateFlow()
}