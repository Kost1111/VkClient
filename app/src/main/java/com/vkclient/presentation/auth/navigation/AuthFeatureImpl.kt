package com.vkclient.presentation.auth.navigation

import android.os.Bundle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.core.util.compose.navigation.createEntryPoint
import com.vkclient.presentation.auth.screen.AuthScreen
import javax.inject.Inject

internal class AuthFeatureImpl @Inject constructor() : AuthFeatureApi {

    override val auth = AuthDestination.Auth.getComposableRoute().createEntryPoint()

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        extras: Bundle?,
    ) {
        with(navGraphBuilder) {
            composable(
                route = AuthDestination.Auth.getComposableRoute(),
            ) {
                AuthScreen()
            }
        }
    }
}
