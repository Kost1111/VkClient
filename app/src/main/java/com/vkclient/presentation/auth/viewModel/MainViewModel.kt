package com.vkclient.presentation.auth.viewModel

import androidx.lifecycle.ViewModel
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vkclient.presentation.auth.model.AuthState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

internal class MainViewModel @Inject constructor() : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Initial)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    init {
        login()
    }

    private fun login() {
        if (VK.isLoggedIn()) {
            _authState.value = AuthState.Authorized
        } else {
            _authState.value = AuthState.NotAuthorized
        }
    }

    fun performAuthResult(result: VKAuthenticationResult) {
        if (result is VKAuthenticationResult.Success) {
            _authState.value = AuthState.Authorized
        } else {
            _authState.value = AuthState.Error
        }
    }
}