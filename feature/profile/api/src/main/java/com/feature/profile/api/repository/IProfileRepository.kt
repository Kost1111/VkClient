package com.feature.profile.api.repository

import com.feature.profile.api.model.WallEntity

interface IProfileRepository {

    suspend fun getProfile(): Result<WallEntity>

    suspend fun getCurrentBoard()

}