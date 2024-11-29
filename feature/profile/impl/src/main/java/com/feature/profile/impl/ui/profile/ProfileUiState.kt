package com.feature.profile.impl.ui.profile

import androidx.compose.runtime.Immutable

@Immutable
data class ProfileUiState(
    val loading: Boolean = false,
    val error: Boolean = false,
)