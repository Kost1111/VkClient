package com.vkclient

import com.core.network.annotations.AuthenticatedRequest
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

data class NewsFeedResponseDto(
    @SerializedName("response") val newsFeedContent: NewsFeedContentDto,
)

data class NewsFeedContentDto(
    @SerializedName("items") val posts: List<PostDto>,
)

data class PostDto(
    @SerializedName("id") val id: String,
    @SerializedName("source_id") val communityId: Long,
    @SerializedName("is_favourite") val isFavourite: Boolean,
    @SerializedName("text") val text: String,
    @SerializedName("date") val date: Long,
)

interface ApiService {

    @AuthenticatedRequest
    @GET("newsfeed.getRecommended?v=5.199")
    suspend fun getRecommended(
        @Query("access_token") token: String,
    ): Response<NewsFeedResponseDto>
}
