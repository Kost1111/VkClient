package com.feature.feed.impl.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp
import com.core.util.compose.ext.CustomViewModelStoreOwner
import com.core.util.compose.ext.rememberDaggerViewModel
import com.feature.feed.impl.di.DaggerFeedComponent

@Composable
fun Screen() {
    val customOwner = remember { CustomViewModelStoreOwner() }

    val feedViewModel: FeedViewModel = rememberDaggerViewModel(
        owner = customOwner,
        factoryProvider = { DaggerFeedComponent.factory().create().getViewModelFactory() }
    )

    Text(text = feedViewModel.getLog(), fontSize = 35.sp)
}



