package com.feature.profile.impl.ui.music

import androidx.compose.runtime.Immutable
import com.core.util.compose.file.Music

@Immutable
internal data class MusicUiState(
    val musics: Set<Music> = emptySet(),
    val loading: Boolean = false,
    val error: Boolean = false,
) {
    fun loading() = copy(loading = true, error = false)

    fun error() = copy(loading = false, error = true)
}