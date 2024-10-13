package com.vkclient.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.core.util.compose.navigation.NavigationManager
import com.feature.feed.api.api.FeedFeatureApi
import com.feature.messenger.api.api.MessengerFeatureApi
import com.feature.profile.api.api.ProfileFeatureApi
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import com.vk.api.sdk.auth.VKAccessToken
import com.vkclient.applicattion.VkClientApp
import com.vkclient.presentation.auth.navigation.AuthFeatureApi
import com.vkclient.presentation.root.navigation.AppFeatureApi
import com.vkclient.presentation.root.screen.AppContent
import com.vkclient.ui.theme.VkClientTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
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
        (applicationContext as VkClientApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        val scope = CoroutineScope(Job() + Dispatchers.Main)
        val storage = VKPreferencesKeyValueStorage(application)
        val token = VKAccessToken.restore(storage)

        Log.i("tag1", "${token!!.accessToken}")

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
