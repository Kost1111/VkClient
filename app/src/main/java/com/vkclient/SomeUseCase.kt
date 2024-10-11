package com.vkclient

import android.util.Log
import com.vkclient.utill.call
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class SomeUseCase @Inject constructor(
    private val apiService: ApiService,
) {
    suspend operator fun invoke(token: String) = withContext(Dispatchers.IO) {
        Log.i("TEST2", "${        apiService.getRecommended(token)
        }")
        apiService.getRecommended(token).call()
    }
}
