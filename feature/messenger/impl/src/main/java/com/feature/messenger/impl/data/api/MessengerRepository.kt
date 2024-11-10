package com.feature.messenger.impl.data.api

import com.feature.messenger.api.repository.IMessageRepository
import javax.inject.Inject

class MessengerRepository @Inject constructor(
    messengerApiService: MessengerApiService
) : IMessageRepository {
    override suspend fun getUserChat() {

    }

    override suspend fun getChatMessages() {
    }
}