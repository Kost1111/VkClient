package com.vkclient

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope
import com.vkclient.applicattion.VkClientApp
import com.vkclient.ui.theme.VkClientTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface AuthState {
    data object Auth : AuthState
    data object NotAuth : AuthState
    data object Initial : AuthState
}

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var useCase: SomeUseCase

    private val _authState = MutableStateFlow<AuthState>(AuthState.Initial)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as VkClientApp).appComponent.inject(this)
        val scope = CoroutineScope(Job())

        fun performAuthResult(result: VKAuthenticationResult) {
            scope.launch {
                if (result is VKAuthenticationResult.Success) {
                    Log.e("TEST1", "VKAuthenticationResult.Success")
                    _authState.value = AuthState.Auth
                } else {
                    Log.e("TEST1", "VKAuthenticationResult.Not")
                    _authState.value = AuthState.NotAuth
                }
            }
        }
        _authState.value = if (VK.isLoggedIn()) AuthState.Auth else AuthState.NotAuth

        enableEdgeToEdge()
        setContent {
            VkClientTheme {
                val launcher = rememberLauncherForActivityResult(
                    contract = VK.getVKAuthActivityResultContract(),
                ) {
                    Log.e("TEST1", "launcher")
                    performAuthResult(it)
                }

                val state = authState.collectAsState()
                LaunchedEffect(launcher, state) {
                    when (state.value) {
                        AuthState.Auth -> {
                            launcher.launch(listOf(VKScope.WALL, VKScope.FRIENDS))

                            val storage = VKPreferencesKeyValueStorage(application)
                            val token = VKAccessToken.restore(storage)

                            useCase(token!!.accessToken)

                            Log.e("TEST1", "Auth")
                        }

                        AuthState.NotAuth -> {
                            launcher.launch(listOf(VKScope.WALL, VKScope.FRIENDS))
                            Log.e("TEST1", "Not Auth")
                        }

                        else -> {}
                    }
                }
            }
        }
    }
}
