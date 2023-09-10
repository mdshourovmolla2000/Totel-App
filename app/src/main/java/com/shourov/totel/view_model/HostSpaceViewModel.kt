package com.shourov.totel.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shourov.totel.model.SpaceClaimModel
import com.shourov.totel.model.SpaceListingModel
import com.shourov.totel.repository.HostSpaceRepository

class HostSpaceViewModel(private val repository: HostSpaceRepository) : ViewModel() {
    private val _spaceListingLiveData = MutableLiveData<List<SpaceListingModel?>>()
    val spaceListingLiveData: LiveData<List<SpaceListingModel?>>
        get() = _spaceListingLiveData

    fun getSpaceListingList() = _spaceListingLiveData.postValue(repository.getSpaceListingList())

    private val _spaceClaimLiveData = MutableLiveData<List<SpaceClaimModel?>>()
    val spaceClaimLiveData: LiveData<List<SpaceClaimModel?>>
        get() = _spaceClaimLiveData

    fun getSpaceClaimList() = _spaceClaimLiveData.postValue(repository.getSpaceClaimList())
}