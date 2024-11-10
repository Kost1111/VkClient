package com.vkclient.presentation.root.navigation

import com.core.util.compose.navigation.FeatureApi
import com.core.util.compose.navigation.NavigationComposeEntry

interface AppFeatureApi : FeatureApi {
    val appTabs: NavigationComposeEntry
}
