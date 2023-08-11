package com.shourov.totel.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shourov.totel.model.HobbyModel
import com.shourov.totel.repository.CreateAccountHobbiesRepository

class CreateAccountHobbiesViewModel(private val repository: CreateAccountHobbiesRepository) : ViewModel() {
    private val _hobbiesLiveData = MutableLiveData<List<HobbyModel>>()
    val hobbiesLiveData: LiveData<List<HobbyModel>>
        get() = _hobbiesLiveData

    fun getHobbies() = _hobbiesLiveData.postValue(repository.getHobbiesList())
}