package com.feature.messenger.api.api

import com.core.util.compose.navigation.FeatureApi
import com.core.util.compose.navigation.NavigationComposeEntry

interface MessengerFeatureApi : FeatureApi {

    val messenger: NavigationComposeEntry

}
