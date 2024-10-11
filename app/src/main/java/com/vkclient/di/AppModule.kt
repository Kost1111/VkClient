package com.vkclient.di

import com.feature.feed.impl.di.FeedModule
import com.vkclient.presentation.auth.navigation.AuthFeatureApi
import com.vkclient.presentation.auth.navigation.AuthFeatureImpl
import dagger.Binds
import dagger.Module

@Module(includes = [MainViewModelModule::class, FeedModule::class])
internal interface AppModule {

    @Binds
    fun bindFeatureApi(authFeatureImpl: AuthFeatureImpl): AuthFeatureApi
}
