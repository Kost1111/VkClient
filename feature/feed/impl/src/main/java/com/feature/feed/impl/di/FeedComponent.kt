package com.feature.feed.impl.di

import com.core.network.di.NetworkModule
import com.core.util.scope.FeatureScope
import dagger.Component


@FeatureScope
@Component(
    modules = [NetworkModule::class]
)

interface FeedComponent {

}