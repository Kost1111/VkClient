package com.feature.profile.impl.di

import androidx.lifecycle.ViewModelProvider
import com.core.network.di.NetworkModule
import com.core.network.di.viewModel.ViewModelFactoryModule
import com.core.util.scope.FeatureScope
import dagger.Component

@FeatureScope
@Component(
    modules = [NetworkModule::class, ViewModelFactoryModule::class, ProfileViewModelModule::class, ProfileModule::class]
)
interface ProfileComponent {

    @Component.Factory
    interface Factory {
        fun create(): ProfileComponent
    }

    @FeatureScope
    fun getViewModelFactory(): ViewModelProvider.Factory


}