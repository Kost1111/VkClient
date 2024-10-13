package com.feature.messenger.api.repository

interface IMessageRepository {

   suspend fun getUserChat()

   suspend fun getChatMessages()

}