package com.core.util.compose.ext

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.core.util.compose.navigation.NavigationActions
import com.core.util.compose.navigation.NavigationCommand

fun NavHostController.processNavigationCommand(navigationCommand: NavigationCommand) {
    when (navigationCommand.actions) {
        NavigationActions.BACK -> {
            navigationCommand
                .destination
                ?.ifBlank { null }
                .let { destination ->
                    if (destination != null) {
                        popBackStack(destination, inclusive = false)
                    } else {
                        navigateUp()
                    }
                }
        }

        NavigationActions.FORWARD -> {
            navigationCommand
                .destination
                ?.ifBlank { null }
                ?.let { destination ->
                    navigate(destination)
                }
        }

        NavigationActions.REPLACE -> {
            navigationCommand
                .destination
                ?.ifBlank { null }
                ?.let { destination ->
                    navigate(destination) {
                        popUpTo(graph.findStartDestination().id) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
        }

        NavigationActions.REPLACE_CURRENT -> {
            navigationCommand
                .destination
                ?.ifBlank { null }
                ?.let { destination ->
                    navigate(destination) {
                        currentBackStackEntry?.destination?.route?.let {
                            popUpTo(it) {
                                inclusive = true
                            }
                        }
                        launchSingleTop = true
                    }
                }
        }
    }
}