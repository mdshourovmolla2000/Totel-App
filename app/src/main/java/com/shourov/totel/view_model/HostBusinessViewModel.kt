package com.shourov.totel.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shourov.totel.model.HostBusinessReviewModel
import com.shourov.totel.repository.HostBusinessRepository

class HostBusinessViewModel(private val repository: HostBusinessRepository) : ViewModel() {
    private val _reviewListLiveData = MutableLiveData<List<HostBusinessReviewModel?>>()
    val reviewListLiveData: LiveData<List<HostBusinessReviewModel?>>
        get() = _reviewListLiveData

    fun getReviewList() = _reviewListLiveData.postValue(repository.getReviewList())
}