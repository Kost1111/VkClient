package com.feature.feed.impl.navigation

import android.os.Bundle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.core.util.compose.navigation.createEntryPoint
import com.feature.feed.api.api.FeedFeatureApi
import com.feature.feed.impl.ui.FeedScreen
import javax.inject.Inject

class FeedFeatureApiImpl @Inject constructor()  : FeedFeatureApi {
    override val feedPost = FeedDestinations.Feed.getComposableRoute().createEntryPoint()

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        extras: Bundle?
    ) {
        with(navGraphBuilder) {
            composable(
                route = FeedDestinations.Feed.getComposableRoute(),
            ) {
                FeedScreen {

                }
            }
        }
    }
}