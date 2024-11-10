package com.vkclient.presentation.root.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.core.util.compose.ext.processNavigationCommand
import com.core.util.compose.navigation.NavigationManager
import com.core.util.compose.navigation.registerGraph
import com.vkclient.presentation.auth.navigation.AuthFeatureApi
import com.vkclient.presentation.root.navigation.AppFeatureApi

@Composable
internal fun AppContent(
    appFeatureApi: AppFeatureApi,
    authFeatureApi: AuthFeatureApi,
    navigationManager: NavigationManager,
) {
    val navController = rememberNavController()
    val currentNavigationManager by rememberUpdatedState(navigationManager)
    LaunchedEffect(currentNavigationManager) {
        currentNavigationManager.commands.collect { command ->
            navController.processNavigationCommand(command)
        }
    }

    NavHost(
        navController = navController,
        startDestination = authFeatureApi.auth.getComposableRoute(),
    ) {
        registerGraph(appFeatureApi)
        registerGraph(authFeatureApi)
    }
}
