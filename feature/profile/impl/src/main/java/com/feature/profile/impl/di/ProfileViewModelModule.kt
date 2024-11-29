package com.feature.profile.impl.di

import androidx.lifecycle.ViewModel
import com.core.network.di.viewModel.ViewModelKey
import com.feature.profile.impl.ui.music.MusicViewModel
import com.feature.profile.impl.ui.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface ProfileViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    fun bindProfileViewModel(profileViewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MusicViewModel::class)
    fun bindMusicViewModel(musicViewModel: MusicViewModel): ViewModel
}