package com.feature.feed.impl.di

import com.core.util.compose.navigation.coreTab.CoreTabFeatureApi
import com.core.util.compose.navigation.coreTab.CoreTabKey
import com.core.util.compose.navigation.coreTab.CoreTabType
import com.feature.feed.api.api.FeedFeatureApi
import com.feature.feed.impl.navigation.FeedFeatureApiImpl
import com.feature.feed.impl.navigation.FeedTabFeatureImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface FeedModule {

    @Binds
    fun bindFeatureApi(feedFeatureApiImpl: FeedFeatureApiImpl): FeedFeatureApi

    @Binds
    @IntoMap
    @CoreTabKey(CoreTabType.FEED_TAB)
    fun bindTabFeatureApi(feedTabFeatureImpl: FeedTabFeatureImpl): CoreTabFeatureApi
}