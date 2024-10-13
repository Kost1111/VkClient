package com.feature.messenger.impl.navigation

import android.os.Bundle
import androidx.navigation.NavGraphBuilder
import com.core.util.compose.navigation.createEntryPoint
import com.feature.messenger.api.api.MessengerFeatureApi
import javax.inject.Inject

class MessengerFeatureApiImpl @Inject constructor() : MessengerFeatureApi {

    override val messenger = MessengerDestinations.Messenger.getComposableRoute().createEntryPoint()

    override fun registerGraph(navGraphBuilder: NavGraphBuilder, extras: Bundle?) {


    }

}