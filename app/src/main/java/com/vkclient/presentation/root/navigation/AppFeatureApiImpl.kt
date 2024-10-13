package com.vkclient.presentation.root.navigation

import android.os.Bundle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.core.util.compose.navigation.coreTab.CoreTabFeatureApi
import com.core.util.compose.navigation.coreTab.CoreTabType
import com.vkclient.presentation.root.screen.BottomBarContent
import javax.inject.Inject

@JvmSuppressWildcards
internal class AppFeatureApiImpl @Inject constructor(
    private val tabsFeatureApis: Map<CoreTabType, CoreTabFeatureApi>,
) : AppFeatureApi {

    override val appTabs = AppDestinations.App

    override fun registerGraph(navGraphBuilder: NavGraphBuilder, extras: Bundle?) {
        navGraphBuilder.composable(route = AppDestinations.App.getComposableRoute()) {
            BottomBarContent(
                tabsFeatureApis = tabsFeatureApis,
            )
        }
    }
}
