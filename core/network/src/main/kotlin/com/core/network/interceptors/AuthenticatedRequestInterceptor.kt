package com.core.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response

internal class AuthenticatedRequestInterceptor(
    private val accessToken: String,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        val url = request.url
            .newBuilder()
            .addQueryParameter(ACCESS_TOKEN_NAME, accessToken)
            .addQueryParameter(VERSION_NAME, API_VERSION)
            .build()

        request = request.newBuilder().url(url).build()

        return chain.proceed(request)
    }

    private companion object {
        const val ACCESS_TOKEN_NAME = "access_token"
        const val VERSION_NAME = "v"
        const val API_VERSION = "5.199"
    }
}