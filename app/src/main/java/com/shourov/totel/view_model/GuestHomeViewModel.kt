package com.shourov.totel.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shourov.totel.model.HomeAlreadyBookedModel
import com.shourov.totel.model.HomeLookingForPartnerModel
import com.shourov.totel.repository.GuestHomeRepository

class GuestHomeViewModel(private val repository: GuestHomeRepository) : ViewModel() {
    private val _homeAlreadyBookedLiveData = MutableLiveData<List<HomeAlreadyBookedModel?>>()
    val homeAlreadyBookedLiveData: LiveData<List<HomeAlreadyBookedModel?>>
        get() = _homeAlreadyBookedLiveData

    fun getHomeAlreadyBooked() = _homeAlreadyBookedLiveData.postValue(repository.getHomeAlreadyBookedList())

    private val _homeLookingForPartnerLiveData = MutableLiveData<List<HomeLookingForPartnerModel?>>()
    val homeLookingForPartnerLiveData: LiveData<List<HomeLookingForPartnerModel?>>
        get() = _homeLookingForPartnerLiveData

    fun getHomeLookingForPartner() = _homeLookingForPartnerLiveData.postValue(repository.getHomeLookingForPartnerList())
}