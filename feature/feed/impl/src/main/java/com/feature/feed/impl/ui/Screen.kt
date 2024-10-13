package com.feature.feed.impl.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.feature.feed.impl.di.DaggerFeedComponent

@Composable
fun Screen(
    back: () -> Unit,
) {
    val viewModel: FeedViewModel =
        viewModel(factory = DaggerFeedComponent.factory().create().getViewModelFactory())

    Column {
        Text(text = viewModel.getLog(), fontSize = 35.sp)

        Button(onClick = back) {
            Text("Back")
        }
    }
}

@Composable
fun Screen2(navController: NavController) {
    val viewModel: FeedViewModel =
        viewModel(factory = DaggerFeedComponent.factory().create().getViewModelFactory())

    Column {
        Text(text = viewModel.getLog(), fontSize = 35.sp)

        Button(onClick = {
            navController.navigateUp()
        }) {
            Text("Back to Screen 1")
        }
    }
}





