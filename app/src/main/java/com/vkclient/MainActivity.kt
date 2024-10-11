package com.vkclient

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.feature.feed.impl.ui.Screen
import com.feature.feed.impl.ui.Screen2
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope
import com.vkclient.applicattion.VkClientApp
import com.vkclient.ui.theme.VkClientTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
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

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as VkClientApp).appComponent.inject(this)
        val scope = CoroutineScope(Job() + Dispatchers.Main)
        val storage = VKPreferencesKeyValueStorage(application)
        val token = VKAccessToken.restore(storage)

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
                val navHostController = rememberNavController()
                val state = authState.collectAsState()

                NavHost(
                    navController = navHostController,
                    startDestination = if (state.value == AuthState.Auth) "Screen1" else "LoginScreen"
                ) {
                    composable("LoginScreen") {
                        LoginScreen(navHostController) { result ->
                            performAuthResult(result)
                        }
                    }
                    composable("Screen1") {
                        Screen(navHostController)
                    }
                    composable("Screen2") {
                        Screen2(navHostController)
                        CoroutineScope(Job()).launch {
                            Log.i("TEST1", "${token?.accessToken}")
//                            useCase.invoke(token?.accessToken!!)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LoginScreen(navController: NavController, onAuthResult: (VKAuthenticationResult) -> Unit) {
    val launcher = rememberLauncherForActivityResult(
        contract = VK.getVKAuthActivityResultContract(),
        onResult = { result ->
            onAuthResult(result)
        }
    )

    Column {
        Text(text = "Please log in")

        Button(onClick = {
            launcher.launch(listOf(VKScope.WALL, VKScope.FRIENDS, VKScope.EMAIL))
        }) {
            Text("Login with VK")
        }
    }
}

