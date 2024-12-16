package com.feature.profile.impl.ui.music

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.util.compose.file.ContentResolver
import com.core.util.compose.navigation.NavigationManager
import com.feature.profile.impl.doman.repository.IMusicRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class MusicViewModel @Inject constructor(
    private val contentResolver: ContentResolver,
    private val navigationManager: NavigationManager,
    private val repository: IMusicRepository,
) : ViewModel() {

    private val _state: MutableStateFlow<MusicUiState> = MutableStateFlow(MusicUiState())
    val state: StateFlow<MusicUiState> = _state.asStateFlow()

    fun getAudioFromUri(uri: Uri) {
        viewModelScope.launch {
            _state.update(MusicUiState::loading)
            val music = contentResolver.getMetadataFromFile(uri)

            if (music != null) {
                _state.update { it.copy(musics = it.musics + music, loading = false) }
            } else {
                Log.e("TEST1", "Не удалось получить инфу о песне/ях")
                _state.update(MusicUiState::error)
            }
        }
    }

    fun bindService() {
        viewModelScope.launch {
            repository.bindMusicService()
            collectMusicData()
        }
    }

    private suspend fun collectMusicData() {
        combine(
            repository.currentMusic(),
            repository.currentDuration(),
            repository.maxDuration(),
            repository.isPlaying(),
        ) { currentMusic, currentDuration, maxDuration, isPlaying ->
            _state.update {
                it.copy(
                    currentMusic = currentMusic,
                    currentDuration = currentDuration,
                    maxDuration = maxDuration,
                    isPlaying = isPlaying,
                )
            }
        }.collect()
    }

    fun playPause() = repository.playPause(_state.value.musics.toList())

    fun unBindService() = repository.unBindService()


    fun back() = navigationManager.back()
}