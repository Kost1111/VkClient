package com.feature.feed.impl.navigation

import androidx.compose.runtime.Composable
import com.core.util.compose.navigation.coreTab.CoreTabFeatureApi
import com.feature.feed.impl.ui.Screen
import javax.inject.Inject

class FeedTabFeatureImpl @Inject constructor(): CoreTabFeatureApi(FeedDestinations.Feed) {

    @Composable
    override fun TabScreen() {
        Screen {

        }
    }
}