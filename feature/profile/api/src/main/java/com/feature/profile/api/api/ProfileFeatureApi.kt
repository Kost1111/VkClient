package com.feature.profile.api.api

import com.core.util.compose.navigation.FeatureApi
import com.core.util.compose.navigation.NavigationComposeEntry

interface ProfileFeatureApi : FeatureApi {

    val profile: NavigationComposeEntry

}