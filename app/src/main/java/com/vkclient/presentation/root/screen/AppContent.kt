package com.vkclient.presentation.root.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.core.util.compose.navigation.registerGraph
import com.vkclient.presentation.auth.navigation.AuthFeatureApi
import com.vkclient.presentation.root.navigation.AppFeatureApi

@Composable
internal fun AppContent(
    appFeatureApi: AppFeatureApi,
    authFeatureApi: AuthFeatureApi,
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = appFeatureApi.appTabs.getComposableRoute()) {
        registerGraph(authFeatureApi)
        registerGraph(appFeatureApi)
    }
}