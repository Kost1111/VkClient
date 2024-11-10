package com.core.network.retrofit

import com.core.network.ApiConstants.API_BASE_URL
import com.core.network.interceptors.AuthenticatedRequestInterceptor
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import com.vk.api.sdk.auth.VKAccessToken
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RetrofitHolderImpl @Inject constructor(
    private val vkPreferencesKeyValueStorage: VKPreferencesKeyValueStorage,
) : RetrofitHolder {

    override var retrofit: Retrofit = build()

    private fun build() = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(API_BASE_URL)
        .client(buildOkhttp())
        .build()

    private fun buildOkhttp(): OkHttpClient {
        val accessToken = VKAccessToken.restore(vkPreferencesKeyValueStorage)?.accessToken.orEmpty()

        return OkHttpClient.Builder()
            .apply {
                addInterceptor(AuthenticatedRequestInterceptor(accessToken))
                addNetworkInterceptor(
                    HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                )
            }
            .build()
    }
}