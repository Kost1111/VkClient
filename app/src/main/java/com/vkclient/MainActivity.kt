package com.vkclient

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope
import com.vkclient.ui.theme.VkClientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkClientTheme {
                val launcher = rememberLauncherForActivityResult(
                    contract = VK.getVKAuthActivityResultContract(),
                ) { result ->
                    when (result) {
                        is VKAuthenticationResult.Success -> {
                            Log.i("tag1", "Success")
                        }

                        is VKAuthenticationResult.Failed -> {
                            Log.i("tag1", "Failed")
                        }
                    }
                }
                LaunchedEffect(launcher) {
                    launcher.launch(listOf(VKScope.WALL))
                }
                val storage = VKPreferencesKeyValueStorage(applicationContext)
                val token = VKAccessToken.restore(storage)
                Log.i("tag2", token.toString())
                if (VK.isLoggedIn()) {
                    Log.i("tag3", "LoggedIn")
                } else {
                    Log.i("tag3", "NotLoggedIn")
                }
            }
        }
    }
}
