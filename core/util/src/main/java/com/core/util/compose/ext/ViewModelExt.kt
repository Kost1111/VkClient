package com.core.util.compose.ext

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
inline fun <reified VM: ViewModel> getViewModel(
    crossinline factoryProvider: () -> ViewModelProvider.Factory
): VM = viewModel(factory = factoryProvider())
