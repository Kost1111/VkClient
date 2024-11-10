package com.feature.feed.impl.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import com.core.util.compose.navigation.coreTab.CoreTabFeatureApi
import javax.inject.Inject

class FeedTabFeatureImpl @Inject constructor() : CoreTabFeatureApi(FeedDestinations.Feed) {

    @Composable
    override fun TabScreen() {

        Box(contentAlignment = Alignment.Center) {
            Text(text = "FeedTab", fontSize = 22.sp)
        }
    }
}