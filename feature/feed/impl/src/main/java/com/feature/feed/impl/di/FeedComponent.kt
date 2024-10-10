package com.feature.feed.impl.di

import androidx.lifecycle.ViewModelProvider
import com.core.network.di.NetworkModule
import com.core.network.di.viewModel.ViewModelFactoryModule
import com.core.util.scope.FeatureScope
import dagger.Component
import javax.inject.Scope


@FeedScope
@Component (
    modules = [NetworkModule::class, ViewModelFactoryModule::class, FeedViewModelModule::class]
)
interface FeedComponent {

    @Component.Factory
    interface Factory {
        fun create(): FeedComponent
    }

    @FeedScope
    fun getViewModelFactory(): ViewModelProvider.Factory

}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FeedScope