package com.core.network.di

import android.app.Application
import com.core.network.retrofit.RetrofitHolder
import com.core.network.retrofit.RetrofitHolderImpl
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface NetworkModule {

    @Binds
    fun bindRetrofitHolder(retrofitHolderImpl: RetrofitHolderImpl): RetrofitHolder

    companion object {
        @Provides
        fun provideVKPreferencesKeyValueStorage(
            context: Application,
        ): VKPreferencesKeyValueStorage {
            return VKPreferencesKeyValueStorage(context = context)
        }
    }
}