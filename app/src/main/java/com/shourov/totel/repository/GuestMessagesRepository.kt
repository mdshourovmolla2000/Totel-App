package com.shourov.totel.repository

import com.shourov.totel.model.MessageModel
import com.shourov.totel.utils.DemoData

class GuestMessagesRepository {
    fun getMessageList(): List<MessageModel?> = DemoData().messageData()
}