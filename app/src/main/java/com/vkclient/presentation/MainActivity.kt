package com.vkclient.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.feature.feed.api.api.FeedFeatureApi
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import com.vk.api.sdk.auth.VKAccessToken
import com.vkclient.applicattion.VkClientApp
import com.vkclient.presentation.auth.navigation.AuthFeatureApi
import com.vkclient.presentation.root.navigation.AppFeatureApi
import com.vkclient.presentation.root.screen.AppContent
import com.vkclient.presentation.root.screen.BottomBarContent
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

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as VkClientApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        val scope = CoroutineScope(Job() + Dispatchers.Main)
        val storage = VKPreferencesKeyValueStorage(application)
        val token = VKAccessToken.restore(storage)

        enableEdgeToEdge()
        setContent {
            VkClientTheme {
                AppContent(
                    appFeatureApi = appFeatureApi,
                    authFeatureApi = authFeatureApi,
                )
            }
        }
    }
}
