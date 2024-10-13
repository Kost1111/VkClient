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

    override suspend fun getProfile(token: String): WallEntity =
        withContext(Dispatchers.IO) {
            apiService.getWall(token).call().response.toEntity()
        }


    override suspend fun getCurrentBoard() {

    }
}