package com.feature.messenger.impl.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import com.core.util.compose.navigation.coreTab.CoreTabFeatureApi
import javax.inject.Inject

class MessengerTabFeatureImpl @Inject constructor(): CoreTabFeatureApi(MessengerDestinations.Messenger) {

    @Composable
    override fun TabScreen() {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Messenger", fontSize = 22.sp)
        }
    }
}