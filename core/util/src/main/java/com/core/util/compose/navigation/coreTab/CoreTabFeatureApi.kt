package com.core.util.compose.navigation.coreTab

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.core.util.compose.navigation.FeatureApi
import com.core.util.compose.navigation.NavigationComposeEntry

abstract class CoreTabFeatureApi (val tabRoute: NavigationComposeEntry) : FeatureApi {

    @Composable
    abstract fun TabScreen()

    final override fun registerGraph(navGraphBuilder: NavGraphBuilder, extras: Bundle?) {
        navGraphBuilder.composable(route = tabRoute.getComposableRoute()) {
            TabScreen()
        }
    }
}