package com.feature.messenger.impl.di

import androidx.lifecycle.ViewModelProvider
import com.core.network.di.viewModel.ViewModelFactoryModule
import com.core.util.scope.FeatureScope
import dagger.Component

@FeatureScope
@Component(
    modules = [ViewModelFactoryModule::class, MessengerViewModelModule::class, MessengerModule::class]
)
interface MessengerComponent {

    @Component.Factory
    interface Factory {
        fun create(): MessengerComponent
    }

    @FeatureScope
    fun getViewModelFactory(): ViewModelProvider.Factory
}


