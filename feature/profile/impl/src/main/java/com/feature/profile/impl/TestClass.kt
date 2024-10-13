package com.feature.profile.impl

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.feature.profile.impl.di.DaggerProfileComponent
import com.feature.profile.impl.ui.ProfileViewModel


@Composable
fun CheckResp() {
    val viewModel: ProfileViewModel =
        viewModel(factory = DaggerProfileComponent.factory().create().getViewModelFactory())

    
}