package com.core.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner




@Composable
inline fun <reified VM : ViewModel> rememberDaggerViewModel(
    owner: ViewModelStoreOwner = LocalContext.current as ViewModelStoreOwner,
    noinline factoryProvider: () -> ViewModelProvider.Factory
): VM {
    val modelFactory = remember(factoryProvider)
    return remember(owner, modelFactory) {
        ViewModelProvider(owner, modelFactory)[VM::class.java]
    }
}

class CustomViewModelStoreOwner : ViewModelStoreOwner {
    override val viewModelStore: ViewModelStore
        get() = ViewModelStore()
}
