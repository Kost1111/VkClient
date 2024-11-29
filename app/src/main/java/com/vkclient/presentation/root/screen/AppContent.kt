package com.vkclient.presentation.root.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.core.util.compose.ext.processNavigationCommand
import com.core.util.compose.navigation.FeatureApi
import com.core.util.compose.navigation.NavigationManager
import com.core.util.compose.navigation.registerGraph
import com.vkclient.presentation.auth.navigation.AuthDestination

@Composable
internal fun AppContent(
    featureApi: List<FeatureApi>,
    navigationManager: NavigationManager,
) {
    val navController = rememberNavController()
    val currentNavigationManager by rememberUpdatedState(navigationManager)
    LaunchedEffect(currentNavigationManager) {
        currentNavigationManager.commands.collect { command ->
            navigationManager.resetCache()
            navController.processNavigationCommand(command)
        }
    }

    NavHost(
        navController = navController,
        startDestination = AuthDestination.Auth(),
    ) {
        featureApi.forEach { featureApi ->
            registerGraph(featureApi)
        }
    }
}
