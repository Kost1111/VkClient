package com.core.network.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Qualifier

@Module
interface CoroutineScopeModule {

    companion object {
        @IoScope
        @Provides
        fun provideIoCoroutineScope(): CoroutineScope = CoroutineScope(Job() + Dispatchers.IO)

        @DefaultScope
        @Provides
        fun provideDefaultCoroutineScope(): CoroutineScope =
            CoroutineScope(Job() + Dispatchers.Default)

        @MainScope
        @Provides
        fun provideMainCoroutineScope(): CoroutineScope = CoroutineScope(Job() + Dispatchers.Main)

        @UnconfinedScope
        @Provides
        fun provideUnconfinedCoroutineScope(): CoroutineScope =
            CoroutineScope(Job() + Dispatchers.Unconfined)
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IoScope

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DefaultScope

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainScope

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UnconfinedScope