package com.vkclient.presentation.root.navigation

import com.core.util.compose.navigation.NavigationComposeEntry

sealed class AppDestinations(route: String) : NavigationComposeEntry {

    override val baseRoute = "$COMMON_TABS_ROUTE/$route"

    operator fun invoke() = getComposableRoute()

    data object App : AppDestinations("APP")

    companion object {

        const val COMMON_TABS_ROUTE = "COMMON_TABS"
    }
}