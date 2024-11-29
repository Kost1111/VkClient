package com.feature.profile.impl.ui.music

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import com.core.util.compose.components.BaseTopBar
import com.core.util.compose.ext.formatMinutesAndSeconds
import com.core.util.compose.ext.getViewModel
import com.core.util.compose.file.Music
import com.feature.profile.impl.ui.profile.getProfileComponent
import com.vkClient.feature.profile.impl.R
import kotlinx.coroutines.Dispatchers

private const val AUDIO_PATH = "audio/*"

@Composable
internal fun MusicScreen() {
    val profileComponent = getProfileComponent()
    val viewModel: MusicViewModel = getViewModel { profileComponent.getViewModelFactory() }

    val state by viewModel.state.collectAsStateWithLifecycle(context = Dispatchers.Main.immediate)

    when {
        state.loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator(modifier = Modifier.size(40.dp))
            }
        }

        else -> {
            Content(
                getAudioFileInfo = { uri -> viewModel.getAudioFromUri(uri) },
                back = viewModel::back,
                musics = state.musics.toList(),
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Content(
    musics: List<Music>,
    getAudioFileInfo: (Uri) -> Unit,
    back: () -> Unit,
) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri ->
        uri?.let {
            getAudioFileInfo(uri)
        }
    }

    BaseTopBar(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .clickable { back() },
                        painter = painterResource(R.drawable.ic_arrow_back),
                        contentDescription = null,
                    )
                },
                title = {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 5.dp),
                        text = "Музыка",
                        textAlign = TextAlign.Center,
                    )
                },
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp),
        ) {
            if (musics.isEmpty()) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(text = "Пока что нет песен")
                    Button(
                        onClick = { launcher.launch(arrayOf(AUDIO_PATH)) }
                    ) {
                        Text(text = "Добавить песни с уcтройства")
                    }
                }
            } else {
                LazyColumn {
                    items(
                        items = musics,
                        key = { it.id }
                    ) {
                        MusicItem(
                            music = it,
                            onItemClick = { }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
            if (musics.isNotEmpty()) {
                FloatingActionButton(
                    modifier = Modifier.align(Alignment.BottomEnd),
                    elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 8.dp),
                    onClick = { launcher.launch(arrayOf(AUDIO_PATH)) }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_refresh),
                        contentDescription = null,
                    )
                }
            }
        }
    }
}

@Composable
fun MusicItem(
    music: Music,
    modifier: Modifier = Modifier,
    color: Color = Color.LightGray.copy(alpha = 0.3f),
    shape: Shape = RoundedCornerShape(8.dp),
    onItemClick: () -> Unit
) {
    Box(
        modifier = modifier
            .background(color, shape)
            .clickable { onItemClick() },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .padding(3.dp)
                    .size(50.dp),
                painter = rememberAsyncImagePainter(
                    model = music.pictureUri,
                    placeholder = painterResource(R.drawable.ic_music),
                    error = painterResource(R.drawable.ic_music),
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier
                    .weight(0.7f)
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    text = music.title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Medium),
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = music.artist,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
            Text(
                modifier = Modifier.weight(0.2f),
                textAlign = TextAlign.Center,
                text = music.duration.formatMinutesAndSeconds(),
                style = MaterialTheme.typography.titleSmall,
                color = Color.Gray,
            )
        }
    }
}

@Preview("MusicScreenPreview")
@Composable
private fun MusicScreenPreview() {
    Content(
        getAudioFileInfo = {},
        back = {},
        musics = listOf(Music("2", "sfsfsfsdsdsd", "sfdsfdf", "sfsdfdfd", 13456, "", null)),
    )
}