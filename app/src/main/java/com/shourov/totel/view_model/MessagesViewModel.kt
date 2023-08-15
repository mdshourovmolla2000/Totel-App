package com.shourov.totel.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shourov.totel.model.MessageModel
import com.shourov.totel.repository.MessagesRepository

class MessagesViewModel(private val repository: MessagesRepository) : ViewModel() {
    private val _messageLiveData = MutableLiveData<List<MessageModel?>>()
    val messageLiveData: LiveData<List<MessageModel?>>
        get() = _messageLiveData

    fun getMessages() = _messageLiveData.postValue(repository.getMessageList())
}