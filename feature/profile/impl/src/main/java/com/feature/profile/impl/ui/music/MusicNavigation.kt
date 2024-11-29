package com.feature.profile.impl.ui.music

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.feature.profile.impl.navigation.ProfileDestinations

internal fun NavGraphBuilder.music() {
    composable(route = ProfileDestinations.Music()) {
        MusicScreen()
    }
}