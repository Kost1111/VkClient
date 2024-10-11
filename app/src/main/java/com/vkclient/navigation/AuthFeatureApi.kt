package com.vkclient.navigation

import com.core.util.compose.navigation.FeatureApi
import com.core.util.compose.navigation.NavigationComposeEntry

interface AuthFeatureApi : FeatureApi {
    val auth : NavigationComposeEntry
}