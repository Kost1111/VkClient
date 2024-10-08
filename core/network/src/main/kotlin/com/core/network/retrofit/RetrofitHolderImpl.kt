package com.core.network.retrofit

import com.core.network.ApiConstants.API_BASE_URL
import com.core.network.interceptors.AuthenticatedRequestInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RetrofitHolderImpl @Inject constructor() : RetrofitHolder {

    override var retrofit: Retrofit = build()

    private fun build() = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(API_BASE_URL)
        .client(buildOkhttp())
        .build()

    private fun buildOkhttp() = OkHttpClient.Builder()
        .apply {
            /*addInterceptor(AuthenticatedRequestInterceptor())*/
            addNetworkInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
        }
        .build()
}