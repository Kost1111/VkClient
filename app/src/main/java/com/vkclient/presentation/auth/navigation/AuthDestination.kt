package com.vkclient.presentation.auth.navigation

import com.core.util.compose.navigation.NavigationComposeEntry

internal sealed class AuthDestination(route: String) : NavigationComposeEntry {

    override val baseRoute = "$COMMON_AUTH_ROUTE/$route"

    operator fun invoke() = getComposableRoute()

    data object Auth : AuthDestination("AUTH")

    private companion object {
        const val COMMON_AUTH_ROUTE = "COMMON_AUTH_ROUTE"
    }
}
