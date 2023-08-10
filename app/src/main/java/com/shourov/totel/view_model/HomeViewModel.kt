package com.shourov.totel.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shourov.totel.model.HomeAlreadyBookedModel
import com.shourov.totel.repository.HomeRepository

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {
    private val _homeAlreadyBookedLiveData = MutableLiveData<List<HomeAlreadyBookedModel?>>()
    val homeAlreadyBookedLiveData: LiveData<List<HomeAlreadyBookedModel?>>
        get() = _homeAlreadyBookedLiveData

    fun getHomeAlreadyBooked() = _homeAlreadyBookedLiveData.postValue(repository.getHomeAlreadyBookedList())
}