package com.vkclient.di

import android.app.Application

internal object DiProvider {

    private lateinit var appComponent: AppComponent

    fun appComponent() = appComponent

    fun buildDi(application: Application) {
        appComponent = DaggerAppComponent.factory().create(application)
    }
}
