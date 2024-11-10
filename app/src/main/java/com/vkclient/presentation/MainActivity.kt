package com.vkclient.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.core.util.compose.navigation.NavigationManager
import com.feature.feed.api.api.FeedFeatureApi
import com.feature.messenger.api.api.MessengerFeatureApi
import com.feature.profile.api.api.ProfileFeatureApi
import com.vkclient.di.DiProvider
import com.vkclient.presentation.auth.navigation.AuthFeatureApi
import com.vkclient.presentation.root.navigation.AppFeatureApi
import com.vkclient.presentation.root.screen.AppContent
import com.vkclient.ui.theme.VkClientTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var authFeatureApi: AuthFeatureApi

    @Inject
    lateinit var feedFeatureApi: FeedFeatureApi

    @Inject
    lateinit var appFeatureApi: AppFeatureApi

    @Inject
    lateinit var navigationManager: NavigationManager

    @Inject
    lateinit var messengerFeatureApi: MessengerFeatureApi

    @Inject
    lateinit var profileFeatureApi: ProfileFeatureApi

    override fun onCreate(savedInstanceState: Bundle?) {
        DiProvider.appComponent().inject(this)
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            VkClientTheme {
                AppContent(
                    navigationManager = navigationManager,
                    appFeatureApi = appFeatureApi,
                    authFeatureApi = authFeatureApi,
                )
            }
        }
    }
}
