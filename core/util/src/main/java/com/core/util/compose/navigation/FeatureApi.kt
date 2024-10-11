package com.core.util.compose.navigation

import android.os.Bundle
import androidx.navigation.NavGraphBuilder

interface FeatureApi {

    fun registerGraph(navGraphBuilder: NavGraphBuilder, extras: Bundle?)
}