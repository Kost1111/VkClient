package com.feature.feed.impl.navigation

import com.core.util.compose.navigation.NavigationComposeEntry

internal sealed class FeedDestinations(route: String): NavigationComposeEntry {

    override val baseRoute = "$COMMON_FEED_ROUTE/$route"

    operator fun invoke() = getComposableRoute()

    data object Feed : FeedDestinations("FEED")

    private companion object {
        const val COMMON_FEED_ROUTE = "COMMON_FEED_ROUTE"
    }
}
