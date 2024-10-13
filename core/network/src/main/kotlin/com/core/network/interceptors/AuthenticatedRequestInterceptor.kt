package com.core.network.interceptors
import com.core.network.ApiConstants.API_VERSION
import com.core.network.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

internal class AuthenticatedRequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().apply {
            val url = url.newBuilder()
                .addQueryParameter("v", API_VERSION)
                .build()

            newBuilder()
                .url(url)
                .build()
        }

        return chain.proceed(request)
    }
}