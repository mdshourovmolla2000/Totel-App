package com.shourov.totel.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shourov.totel.model.MessageModel
import com.shourov.totel.model.NotificationModel
import com.shourov.totel.repository.GuestMessagesRepository
import com.shourov.totel.repository.HostInboxRepository

class HostInboxViewModel(private val repository: HostInboxRepository) : ViewModel() {
    private val _messageLiveData = MutableLiveData<List<MessageModel?>>()
    val messageLiveData: LiveData<List<MessageModel?>>
        get() = _messageLiveData

    fun getMessages() = _messageLiveData.postValue(repository.getMessageList())

    private val _notificationLiveData = MutableLiveData<List<NotificationModel?>>()
    val notificationLiveData: LiveData<List<NotificationModel?>>
        get() = _notificationLiveData

    fun getNotification() = _notificationLiveData.postValue(repository.getNotificationList())
}