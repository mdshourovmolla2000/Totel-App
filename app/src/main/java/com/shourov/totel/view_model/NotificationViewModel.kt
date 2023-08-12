package com.shourov.totel.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shourov.totel.model.NotificationModel
import com.shourov.totel.repository.NotificationRepository

class NotificationViewModel(private val repository: NotificationRepository) : ViewModel() {
    private val _notificationLiveData = MutableLiveData<List<NotificationModel?>>()
    val notificationLiveData: LiveData<List<NotificationModel?>>
        get() = _notificationLiveData

    fun getNotification() = _notificationLiveData.postValue(repository.getNotificationList())
}