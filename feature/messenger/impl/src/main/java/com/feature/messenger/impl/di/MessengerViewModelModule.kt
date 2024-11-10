package com.feature.messenger.impl.di

import androidx.lifecycle.ViewModel
import com.core.network.di.viewModel.ViewModelKey
import com.feature.messenger.impl.ui.MessengerViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface MessengerViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(MessengerViewModel::class)
    fun bindMessengerViewModel(messengerVIewModel: MessengerViewModel): ViewModel
}