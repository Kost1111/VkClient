package com.feature.profile.impl.data.api

import com.feature.profile.impl.data.model.Root
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProfileApiService {

    @GET("wall.get?v=5.199")
    suspend fun getWall(
        @Query("access_token") token: String
    ): Response<Root>
}