package com.feature.profile.impl.di

import androidx.lifecycle.ViewModelProvider
import com.core.util.scope.FeatureScope
import dagger.Subcomponent

@FeatureScope
@Subcomponent(
    modules = [
        ProfileViewModelModule::class,
        ProfileModule::class,
    ]
)
interface ProfileComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ProfileComponent
    }

    fun getViewModelFactory(): ViewModelProvider.Factory
}