package com.core.util.compose.navigation

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

fun NavGraphBuilder.registerGraph(featureApi: FeatureApi, extras: Bundle? = null) {

    featureApi.registerGraph(
        navGraphBuilder = this,
        extras = extras,
    )
}