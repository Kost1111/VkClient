package com.feature.feed.api.api

import com.core.util.compose.navigation.FeatureApi
import com.core.util.compose.navigation.NavigationComposeEntry

interface FeedFeatureApi: FeatureApi {

    val feedPost: NavigationComposeEntry
}