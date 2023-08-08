package com.shourov.totel.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shourov.totel.model.OnBoardingModel
import com.shourov.totel.repository.OnBoardingRepository

class OnBoardingViewModel(private val repository: OnBoardingRepository): ViewModel() {
    private val _onBoardingLiveData = MutableLiveData<List<OnBoardingModel>>()
    val onBoardingLiveData: LiveData<List<OnBoardingModel>>
        get() = _onBoardingLiveData

    fun getOnBoardingData() = _onBoardingLiveData.postValue(repository.getOnBoardingData())
}