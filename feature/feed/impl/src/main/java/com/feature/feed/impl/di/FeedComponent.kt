package com.feature.feed.impl.di

import androidx.lifecycle.ViewModelProvider
import com.core.util.scope.FeatureScope
import dagger.Subcomponent
import javax.inject.Scope

@FeatureScope
@Subcomponent (
    modules = [
        FeedViewModelModule::class,
        FeedModule::class
    ]
)
interface FeedComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FeedComponent
    }

    fun getViewModelFactory(): ViewModelProvider.Factory
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FeedScope