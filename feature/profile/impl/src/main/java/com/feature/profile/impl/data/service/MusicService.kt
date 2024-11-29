package com.feature.profile.impl.data.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import javax.inject.Inject

internal class MusicService @Inject constructor() : Service() {

    val binder = MusicBinder()

    inner class MusicBinder : Binder() {

        fun getService() = this@MusicService

    }

    override fun onBind(p0: Intent?): IBinder {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action) {
            "Prev" -> {

            }

            "Next" -> {

            }

            "Stop" -> {

            }

            else -> {

            }
        }
        return START_STICKY
    }
}