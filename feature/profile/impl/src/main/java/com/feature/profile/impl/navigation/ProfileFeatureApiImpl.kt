package com.feature.profile.impl.navigation

import android.os.Bundle
import androidx.navigation.NavGraphBuilder
import com.core.util.compose.navigation.createEntryPoint
import com.feature.profile.api.api.ProfileFeatureApi
import javax.inject.Inject

class ProfileFeatureApiImpl @Inject constructor() : ProfileFeatureApi {

    override val profile = ProfileDestinations.Messenger.getComposableRoute().createEntryPoint()

    override fun registerGraph(navGraphBuilder: NavGraphBuilder, extras: Bundle?) {

    }
}