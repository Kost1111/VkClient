package com.vkclient.navigation

import android.os.Bundle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.core.util.compose.navigation.createEntryPoint
import com.vkclient.AuthFeatureApi
import javax.inject.Inject

internal class AuthFeatureImpl @Inject constructor() : com.vkclient.AuthFeatureApi {

    override val auth = AuthDestination.Auth.getComposableRoute().createEntryPoint()

    override fun registerGraph(navGraphBuilder: NavGraphBuilder, extras: Bundle?) {
        with(navGraphBuilder) {
            composable(
                route = com.vkclient.navigation.AuthDestination.Auth.getComposableRoute()
            ) {

            }
        }
    }
}