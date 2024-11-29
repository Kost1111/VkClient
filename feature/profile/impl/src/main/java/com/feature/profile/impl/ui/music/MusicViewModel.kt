package com.feature.profile.impl.ui.music

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.util.compose.file.ContentResolver
import com.core.util.compose.navigation.NavigationManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class MusicViewModel @Inject constructor(
    private val contentResolver: ContentResolver,
    private val navigationManager: NavigationManager,
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

    fun back() = navigationManager.back()
}