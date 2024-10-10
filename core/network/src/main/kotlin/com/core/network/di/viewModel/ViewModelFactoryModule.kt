package com.core.network.di.viewModel

import androidx.lifecycle.ViewModelProvider
import com.core.network.di.viewModel.ViewModelFactory
import dagger.Binds
import dagger.Module


@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}