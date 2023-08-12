package com.shourov.totel.repository

import com.shourov.totel.model.NotificationModel
import com.shourov.totel.utils.DemoData

class NotificationRepository {
    fun getNotificationList(): List<NotificationModel?> = DemoData().notificationData()
}