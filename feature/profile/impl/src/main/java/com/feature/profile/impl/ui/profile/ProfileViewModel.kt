package com.feature.profile.impl.ui.profile

import androidx.lifecycle.ViewModel
import com.core.util.compose.navigation.NavigationManager
import com.feature.profile.api.repository.IProfileRepository
import com.feature.profile.impl.navigation.ProfileDestinations
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val profileRepository: IProfileRepository,
    private val navigationManager: NavigationManager,
) : ViewModel() {

    init {

    }

    fun goToMusicScreen() = navigationManager.navigateTo(ProfileDestinations.Music())
}

