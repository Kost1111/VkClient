package com.feature.profile.impl.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import com.core.util.compose.navigation.coreTab.CoreTabFeatureApi
import com.feature.profile.impl.ui.ProfileScreen
import javax.inject.Inject

class ProfileTabFeatureImpl @Inject constructor() :
    CoreTabFeatureApi(ProfileDestinations.Messenger) {

    @SuppressLint("UnrememberedMutableState")
    @Composable
    override fun TabScreen() {
        ProfileScreen()
    }
}