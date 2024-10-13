package com.core.network.ext

import retrofit2.Response

import android.util.Log

fun <T> Response<T>.call(): T = this.call { it }

inline fun <T, R> Response<T>.call(function: ((T) -> R)): R {
    return if (this.isSuccessful) {
        val t = this.body()
        if (t != null) {
            try {
                function.invoke(t)
            } catch (e: Exception) {
                throw e
            }
        } else {
            Log.e("ResponseCall", "Response body is null or empty")
            // Возвращаем значение по умолчанию или null, если необходимо
            throw IllegalArgumentException("Response body is null or empty")
        }
    } else {
        Log.e("ResponseCall", "Response is not successful: ${this.code()} - ${this.message()}")
        throw IllegalArgumentException("Response is not successful")
    }
}
