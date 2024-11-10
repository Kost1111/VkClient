package com.core.util.compose.navigation

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface FeatureApi {
    fun registerGraph(navGraphBuilder: NavGraphBuilder, extras: Bundle?)
}