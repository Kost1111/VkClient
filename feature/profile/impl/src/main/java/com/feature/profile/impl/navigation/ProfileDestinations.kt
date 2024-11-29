package com.feature.profile.impl.navigation

import com.core.util.compose.navigation.NavigationComposeEntry

internal sealed class ProfileDestinations(route: String) : NavigationComposeEntry {

    override val baseRoute = "$COMMON_PROFILE_ROUTE/$route"

    operator fun invoke() = getComposableRoute()

    data object Messenger : ProfileDestinations("PROFILE")

    data object Music: ProfileDestinations("MUSIC")

    private companion object {
        const val COMMON_PROFILE_ROUTE = "COMMON_PROFILE_ROUTE"
    }
}