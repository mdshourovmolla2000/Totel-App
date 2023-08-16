package com.shourov.totel.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shourov.totel.model.ProfileAlreadyBookedModel
import com.shourov.totel.repository.GuestProfileRepository

class GuestProfileViewModel(private val repository: GuestProfileRepository) : ViewModel() {
    private val _profileAlreadyBookedLiveData = MutableLiveData<List<ProfileAlreadyBookedModel?>>()
    val profileAlreadyBookedLiveData: LiveData<List<ProfileAlreadyBookedModel?>>
        get() = _profileAlreadyBookedLiveData

    fun getProfileAlreadyBooked() = _profileAlreadyBookedLiveData.postValue(repository.getProfileAlreadyBookedList())
}