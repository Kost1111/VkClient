package com.feature.profile.impl.doman.repository

import com.core.util.compose.file.Music
import kotlinx.coroutines.flow.StateFlow

interface IMusicRepository {

    fun bindMusicService()

    fun playPause(musics: List<Music>)

    fun currentMusic(): StateFlow<Music>

    fun currentDuration(): StateFlow<Float>

    fun maxDuration(): StateFlow<Float>

    fun isPlaying(): StateFlow<Boolean>

    fun unBindService()
}