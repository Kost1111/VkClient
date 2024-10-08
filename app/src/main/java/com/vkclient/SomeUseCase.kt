package com.vkclient

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

fun <T> Response<T>.call(): T = this.call { it }

inline fun <T, R> Response<T>.call(function: ((T) -> R)): R = if (this.isSuccessful) {
    val t = this.body() ?: throw IllegalArgumentException()
    try {
        function.invoke(t)
    } catch (e: Exception) {
        throw e
    }
} else {
    throw IllegalArgumentException()
}

class SomeUseCase @Inject constructor(
    private val apiService: ApiService,
) {
    suspend operator fun invoke(token: String) = withContext(Dispatchers.IO) {
        apiService.getRecommended(token).call()
    }
}
