package com.feature.feed.impl.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.feature.feed.impl.di.FeedComponent
import com.feature.feed.impl.di.FeedComponentProvider

private lateinit var feedComponent: FeedComponent

@Composable
internal fun FeedScreen(
    back: () -> Unit,
) {
    feedComponent = (LocalContext.current.applicationContext as FeedComponentProvider).provideFeedComponent()

    val viewModel: FeedViewModel =
        viewModel(factory = feedComponent.getViewModelFactory())

    Column {
        Text(text = viewModel.getLog(), fontSize = 35.sp)

        Button(onClick = back) {
            Text("Back")
        }
    }
}