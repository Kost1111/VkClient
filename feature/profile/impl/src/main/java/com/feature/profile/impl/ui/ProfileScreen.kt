package com.feature.profile.impl.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.feature.profile.impl.di.ProfileComponent
import com.feature.profile.impl.di.ProfileComponentProvider

private lateinit var profileComponent: ProfileComponent

@Composable
internal fun ProfileScreen() {
    profileComponent = (LocalContext.current.applicationContext as ProfileComponentProvider).provideProfileComponent()

    val viewModel: ProfileViewModel =
        viewModel(factory = profileComponent.getViewModelFactory())


}