package com.feature.profile.impl.navigation

import androidx.compose.runtime.Composable
import com.core.util.compose.navigation.coreTab.CoreTabFeatureApi
import com.feature.profile.impl.ui.profile.ProfileScreen
import javax.inject.Inject

class ProfileTabFeatureImpl @Inject constructor() :
    CoreTabFeatureApi(ProfileDestinations.Messenger) {

    @Composable
    override fun TabScreen() {
        ProfileScreen()
    }
}