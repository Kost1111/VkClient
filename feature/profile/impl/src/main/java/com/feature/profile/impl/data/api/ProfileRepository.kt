package com.feature.profile.impl.data.api

import com.core.network.ext.call
import com.feature.profile.api.model.WallEntity
import com.feature.profile.api.repository.IProfileRepository
import com.feature.profile.impl.data.mapper.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProfileRepository @Inject constructor(private val apiService: ProfileApiService) :
    IProfileRepository {

    override suspend fun getProfile(): Result<WallEntity> = runCatching {
        withContext(Dispatchers.IO) {
            apiService.getWall().call().response?.toEntity()
                ?: throw TechException("Error in mapping")
        }
    }

    override suspend fun getCurrentBoard() {

    }

    private class TechException(errorMes: String): Exception(errorMes)
}