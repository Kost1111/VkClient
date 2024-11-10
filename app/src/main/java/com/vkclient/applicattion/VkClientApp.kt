package com.vkclient.applicattion

import android.app.Application
import com.vkclient.di.DiProvider
import com.vkclient.di.SubComponents

class VkClientApp : Application(), SubComponents {

    override fun onCreate() {
        super.onCreate()
        DiProvider.buildDi(this)
    }
}
