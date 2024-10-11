package com.core.network.di

import com.core.network.retrofit.RetrofitHolder
import com.core.network.retrofit.RetrofitHolderImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
interface NetworkModule {


    @Binds
    fun bindRetrofitHolder(retrofitHolderImpl: RetrofitHolderImpl): RetrofitHolder
}