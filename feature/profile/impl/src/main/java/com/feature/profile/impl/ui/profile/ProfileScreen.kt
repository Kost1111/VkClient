package com.feature.profile.impl.ui.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.core.util.compose.components.BaseTopBar
import com.core.util.compose.ext.getViewModel
import com.feature.profile.impl.di.ProfileComponent
import com.feature.profile.impl.di.ProfileComponentProvider

@Composable
internal fun ProfileScreen() {
    val profileComponent = getProfileComponent()
    val viewModel: ProfileViewModel = getViewModel { profileComponent.getViewModelFactory() }

    Content(
        onClick = viewModel::goToMusicScreen
    )
}

@Composable
private fun Content(
    onClick: () -> Unit,
) {
    BaseTopBar {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Button(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 20.dp),
                onClick = onClick
            ) {
                Text(text = "Музыка")
            }
        }
    }
}

@Composable
internal fun getProfileComponent(): ProfileComponent {
    val context = LocalContext.current.applicationContext as ProfileComponentProvider
    return remember { context.provideProfileComponent() }
}

@Preview("ProfileScreenPreview")
@Composable
private fun ProfileScreenPreview() {
    Content(
        onClick = {},
    )
}