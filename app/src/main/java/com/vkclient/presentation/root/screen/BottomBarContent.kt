package com.vkclient.presentation.root.screen

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.core.util.compose.navigation.coreTab.CoreTabFeatureApi
import com.core.util.compose.navigation.coreTab.CoreTabType
import com.core.util.compose.navigation.registerGraph
import com.vkclient.R

@Composable
internal fun BottomBarContent(
    tabsFeatureApis: Map<CoreTabType, CoreTabFeatureApi>
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
            tabsRoutes.forEach { tab ->
                NavigationBar {
                    NavigationBarItem(
                        selected = tab.key == currentRoute,
                        onClick = {
                            if (tab.key != currentRoute) {
                                navController.navigate(tab.key) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                        icon = { Icon(
                            painter = painterResource(id = android.R.drawable.ic_menu_add),
                            contentDescription = null,
                        ) },
                    )
                }
            }

        }
    ) {
        val startRoute = remember { tabsRoutes.keys.first() }

        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = startRoute,
        ) {
            tabsFeatureApis.values.forEach { tabFeatureApi -> registerGraph(tabFeatureApi) }
        }
    }

}