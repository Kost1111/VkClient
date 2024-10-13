package com.feature.profile.impl.di

import com.core.network.retrofit.RetrofitHolder
import com.core.util.compose.navigation.coreTab.CoreTabFeatureApi
import com.core.util.compose.navigation.coreTab.CoreTabKey
import com.core.util.compose.navigation.coreTab.CoreTabType
import com.core.util.scope.AppScope
import com.core.util.scope.FeatureScope
import com.feature.profile.api.api.ProfileFeatureApi
import com.feature.profile.api.repository.IProfileRepository
import com.feature.profile.impl.data.api.ProfileApiService
import com.feature.profile.impl.data.api.ProfileRepository
import com.feature.profile.impl.navigation.ProfileFeatureApiImpl
import com.feature.profile.impl.navigation.ProfileTabFeatureImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap


@Module
interface ProfileModule {

    @AppScope
    @Binds
    fun bindProfileFeatureApi(profileFeatureApi: ProfileFeatureApiImpl): ProfileFeatureApi

    @AppScope
    @Binds
    @IntoMap
    @CoreTabKey(CoreTabType.PROFILE_TAB)
    fun bindTabFeatureApi(profileTabFeatureImpl: ProfileTabFeatureImpl): CoreTabFeatureApi

    @FeatureScope
    @Binds
    fun bindProfileRepository(profileRepository: ProfileRepository): IProfileRepository

    companion object {
        @Provides
        fun provideProfileApiService(retrofitHolder: RetrofitHolder): ProfileApiService {
            return retrofitHolder.retrofit.create(ProfileApiService::class.java)
        }
    }
}