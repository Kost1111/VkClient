package com.feature.feed.api.domain.repository

interface IFeedRepository {

    suspend fun getFeedRecommendedPosts()

}