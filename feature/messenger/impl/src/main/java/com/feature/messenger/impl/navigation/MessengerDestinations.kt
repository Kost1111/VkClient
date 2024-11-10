package com.feature.messenger.impl.navigation

import com.core.util.compose.navigation.NavigationComposeEntry

internal sealed class MessengerDestinations(route: String): NavigationComposeEntry {
    override val baseRoute = "$COMMON_MESSENGER_ROUTE/$route"

    operator fun invoke() = getComposableRoute()

    data object Messenger : MessengerDestinations("MESSENGER")

    private companion object {
        const val COMMON_MESSENGER_ROUTE = "COMMON_MESSENGER_ROUTE"
    }
}