package com.feature.profile.impl.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import com.core.util.compose.navigation.coreTab.CoreTabFeatureApi
import com.feature.profile.impl.CheckResp
import javax.inject.Inject

class ProfileTabFeatureImpl @Inject constructor() :
    CoreTabFeatureApi(ProfileDestinations.Messenger) {

    @SuppressLint("UnrememberedMutableState")
    @Composable
    override fun TabScreen() {
        CheckResp()
    }
}