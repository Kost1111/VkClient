package com.feature.messenger.impl.di

import com.core.util.compose.navigation.coreTab.CoreTabFeatureApi
import com.core.util.compose.navigation.coreTab.CoreTabKey
import com.core.util.compose.navigation.coreTab.CoreTabType
import com.feature.messenger.api.api.MessengerFeatureApi
import com.feature.messenger.impl.navigation.MessengerFeatureApiImpl
import com.feature.messenger.impl.navigation.MessengerTabFeatureImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface MessengerModule {

    @Binds
    fun bindMessengerFeatureApi(messengerFeatureApi: MessengerFeatureApiImpl): MessengerFeatureApi

    @Binds
    @IntoMap
    @CoreTabKey(CoreTabType.MESSENGER_TAB)
    fun bindTabFeatureApi(messengerTabFeatureImpl: MessengerTabFeatureImpl): CoreTabFeatureApi
}