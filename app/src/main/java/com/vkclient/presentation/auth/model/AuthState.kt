package com.vkclient.presentation.auth.model

sealed interface AuthState {

    data object Authorized : AuthState

    data object NotAuthorized : AuthState

    data object Error : AuthState

    data object Initial : AuthState
}
