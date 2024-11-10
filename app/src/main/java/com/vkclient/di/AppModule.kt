package com.vkclient.di

import com.core.network.di.NetworkComponent
import com.feature.feed.impl.di.FeedComponent
import com.feature.feed.impl.di.FeedModule
import com.feature.messenger.impl.di.MessengerModule
import com.feature.profile.impl.di.ProfileComponent
import com.feature.profile.impl.di.ProfileModule
import com.vkclient.presentation.auth.navigation.AuthFeatureApi
import com.vkclient.presentation.auth.navigation.AuthFeatureImpl
import com.vkclient.presentation.root.navigation.AppFeatureApi
import com.vkclient.presentation.root.navigation.AppFeatureApiImpl
import dagger.Binds
import dagger.Module

@Module(
    subcomponents = [
        FeedComponent::class,
        NetworkComponent::class,
        ProfileComponent::class,
    ],
    includes = [
        ViewModelModule::class,
        FeedModule::class,
        MessengerModule::class,
        ProfileModule::class,
    ],
)
internal interface AppModule {

    @Binds
    fun bindFeatureApi(authFeatureImpl: AuthFeatureImpl): AuthFeatureApi

    @Binds
    fun bindAppFeatureApi(appFeatureApiImpl: AppFeatureApiImpl): AppFeatureApi
}
