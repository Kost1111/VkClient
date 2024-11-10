package com.vkclient.di

import androidx.lifecycle.ViewModel
import com.core.network.di.viewModel.ViewModelKey
import com.core.util.scope.AppScope
import com.vkclient.presentation.auth.viewModel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface ViewModelModule {

    @AppScope
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}
