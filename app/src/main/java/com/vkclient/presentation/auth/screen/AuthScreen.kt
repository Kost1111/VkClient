package com.vkclient.presentation.auth.screen

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKScope
import com.vkclient.applicattion.VkClientApp
import com.vkclient.presentation.auth.model.AuthState
import com.vkclient.presentation.auth.viewModel.MainViewModel
import kotlinx.coroutines.Dispatchers

@Composable
fun AuthScreen() {
    val component = (LocalContext.current.applicationContext as VkClientApp).appComponent
    val viewModel: MainViewModel = viewModel(factory = component.getViewModelFactory())

    val state = viewModel.authState.collectAsState(Dispatchers.Main.immediate)

    val launcher = rememberLauncherForActivityResult(
        contract = VK.getVKAuthActivityResultContract(),
        onResult = { result ->
            viewModel.performAuthResult(result)
        },
    )
    val scope = rememberCoroutineScope()

    when (state.value) {
        AuthState.Authorized -> {
//            LaunchedEffect(Unit) {
//                scope.launch {
            viewModel.goToFeed()
//                }
//            }
        }

        AuthState.NotAuthorized -> {
            Column {
                Text(text = "Please log in")
                Button(onClick = {
                    launcher.launch(listOf(VKScope.WALL, VKScope.FRIENDS, VKScope.EMAIL))
                }) {
                    Text("Login with VK")
                }
            }
        }

        else -> {}
    }
}
