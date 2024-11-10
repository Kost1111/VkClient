package com.feature.feed.impl.data.api

import com.feature.feed.api.domain.repository.IFeedRepository
import javax.inject.Inject

internal class FeedRepository @Inject constructor(
    private val feedApiService: FeedApiService
) : IFeedRepository {
    override suspend fun getFeedRecommendedPosts() {
        TODO()
    }
}