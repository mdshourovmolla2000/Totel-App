package com.shourov.totel.repository

import com.shourov.totel.model.MessageModel
import com.shourov.totel.model.NotificationModel
import com.shourov.totel.utils.DemoData

class HostInboxRepository {
    fun getMessageList(): List<MessageModel?> = DemoData().messageData()

    fun getNotificationList(): List<NotificationModel?> = DemoData().notificationData()
}