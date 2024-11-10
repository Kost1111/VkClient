package com.feature.profile.impl.data.api

import com.feature.profile.impl.data.model.Root
import retrofit2.Response
import retrofit2.http.GET

interface ProfileApiService {

    @GET("wall.get?v=5.199")
    suspend fun getWall(): Response<Root>
}