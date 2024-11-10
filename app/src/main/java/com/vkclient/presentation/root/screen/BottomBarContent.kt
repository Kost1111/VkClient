package com.vkclient.presentation.root.screen

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.core.util.compose.navigation.coreTab.CoreTabFeatureApi
import com.core.util.compose.navigation.coreTab.CoreTabType
import com.core.util.compose.navigation.registerGraph

@Composable
internal fun BottomBarContent(
    tabsFeatureApis: Map<CoreTabType, CoreTabFeatureApi>,
) {
    val tabsRoutes = remember {
        tabsFeatureApis
            .entries
            .sortedBy { it.key.ordinal }
            .associate { it.value.tabRoute.getComposableRoute() to it.key }
    }

    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars),
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.onPrimary,
            ) {
                tabsRoutes.forEach { (route, tabType) ->
                    NavigationBarItem(
                        selected = route == currentRoute,
                        onClick = {
                            if (route != currentRoute) {
                                navController.navigate(route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = getTabIcon(tabType),
                                contentDescription = null,
                                tint = if (route == currentRoute) MaterialTheme.colorScheme.primary else Color.Gray,
                            )
                        },
                        label = {
                            Text(
                                text = getTabLabel(tabType),
                                color = if (route == currentRoute) MaterialTheme.colorScheme.primary else Color.Gray,
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent,
                        ),
                    )
                }
            }
        },
    ) {
        val startRoute = remember { tabsRoutes.keys.first() }

        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = startRoute,
        ) {
            tabsFeatureApis.values.forEach { tabFeatureApi ->
                registerGraph(tabFeatureApi)
            }
        }
    }
}

@Composable
fun getTabIcon(tabType: CoreTabType): ImageVector {
    return when (tabType) {
        CoreTabType.FEED_TAB -> Icons.Default.Home
        CoreTabType.MESSENGER_TAB -> Icons.Default.Email
        CoreTabType.PROFILE_TAB -> Icons.Default.Person
        else -> Icons.Default.Home
    }
}

fun getTabLabel(tabType: CoreTabType): String {
    return when (tabType) {
        CoreTabType.FEED_TAB -> "Feed"
        CoreTabType.MESSENGER_TAB -> "Messenger"
        CoreTabType.PROFILE_TAB -> "Profile"
        else -> "Other"
    }
}
