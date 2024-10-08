package com.vkclient.di

import com.core.network.retrofit.RetrofitHolder
import com.vkclient.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface AppModule {

    companion object {
        @Singleton
        @Provides
        fun provideApiService(holder: RetrofitHolder): ApiService =
            holder.retrofit.create(ApiService::class.java)
    }
}
