package com.vkclient.di

import com.core.network.di.NetworkComponent
import com.core.network.di.NetworkComponentProvider
import com.feature.feed.impl.di.FeedComponent
import com.feature.feed.impl.di.FeedComponentProvider
import com.feature.profile.impl.di.ProfileComponent
import com.feature.profile.impl.di.ProfileComponentProvider

interface SubComponents :
    FeedComponentProvider,
    NetworkComponentProvider,
    ProfileComponentProvider {

    override fun provideFeedComponent(): FeedComponent {
        return DiProvider.appComponent().feedComponent.create()
    }

    override fun provideNetworkComponent(): NetworkComponent {
        return DiProvider.appComponent().networkComponent.create()
    }

    override fun provideProfileComponent(): ProfileComponent {
        return DiProvider.appComponent().profileComponent.create()
    }
}
