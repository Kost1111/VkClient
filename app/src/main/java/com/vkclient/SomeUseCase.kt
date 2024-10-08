package com.vkclient

import com.vkclient.utill.call
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class SomeUseCase @Inject constructor(
    private val apiService: ApiService,
) {
    suspend operator fun invoke(token: String) = withContext(Dispatchers.IO) {
        apiService.getRecommended(token).call()
    }
}
