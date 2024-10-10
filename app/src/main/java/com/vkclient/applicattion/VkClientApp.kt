package com.vkclient.applicattion

import android.app.Application
import com.vkclient.di.AppComponent
import com.vkclient.di.DaggerAppComponent

class VkClientApp : Application() {

    private var _appComponent: AppComponent? = null
    val appComponent: AppComponent get() = requireNotNull(_appComponent)

    override fun onCreate() {
        super.onCreate()

        _appComponent = DaggerAppComponent.builder()
            .app(this)
            .build()
    }
}
