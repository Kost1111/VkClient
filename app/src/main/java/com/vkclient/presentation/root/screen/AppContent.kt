package com.vkclient.presentation.root.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.core.util.compose.ext.processNavigationCommand
import com.core.util.compose.navigation.NavigationManager
import com.core.util.compose.navigation.registerGraph
import com.feature.feed.api.api.FeedFeatureApi
import com.vkclient.presentation.auth.navigation.AuthFeatureApi
import com.vkclient.presentation.root.navigation.AppFeatureApi
import kotlinx.coroutines.isActive

@Composable
internal fun AppContent(
    appFeatureApi: AppFeatureApi,
    authFeatureApi: AuthFeatureApi,
    feedFeatureApi: FeedFeatureApi,
    navigationManager: NavigationManager,
) {
    val navController = rememberNavController()
    val currentNavigationManager by rememberUpdatedState(navigationManager)

    LaunchedEffect(key1 = currentNavigationManager) {
        Log.e("TEST1", "LaunchedEffect")
        navigationManager.resetCache()
        Log.e("TEST1", "LaunchedEffect coroutine: ${this.coroutineContext.isActive}")
        navigationManager.commands.collect { command ->
            Log.e("TEST1", "Не работает падла collect: $command")
            navController.processNavigationCommand(command)
        }
    }

    NavHost(
        navController = navController,
        startDestination = authFeatureApi.auth.getComposableRoute(),
    ) {
        // registerGraph(appFeatureApi)
        registerGraph(authFeatureApi)
        registerGraph(feedFeatureApi)
    }
}
