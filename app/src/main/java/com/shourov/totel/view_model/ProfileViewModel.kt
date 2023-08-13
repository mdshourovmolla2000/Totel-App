package com.shourov.totel.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shourov.totel.model.ProfileAlreadyBookedModel
import com.shourov.totel.repository.ProfileRepository

class ProfileViewModel(private val repository: ProfileRepository) : ViewModel() {
    private val _profileAlreadyBookedLiveData = MutableLiveData<List<ProfileAlreadyBookedModel?>>()
    val profileAlreadyBookedLiveData: LiveData<List<ProfileAlreadyBookedModel?>>
        get() = _profileAlreadyBookedLiveData

    fun getProfileAlreadyBooked() = _profileAlreadyBookedLiveData.postValue(repository.getProfileAlreadyBookedList())
}