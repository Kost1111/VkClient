package com.vkclient.utill

import retrofit2.Response

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