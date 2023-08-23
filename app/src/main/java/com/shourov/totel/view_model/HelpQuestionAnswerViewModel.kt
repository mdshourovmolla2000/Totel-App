package com.shourov.totel.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shourov.totel.model.HelpQuestionAnswerModel
import com.shourov.totel.repository.HelpQuestionAnswerRepository

class HelpQuestionAnswerViewModel(private val repository: HelpQuestionAnswerRepository) : ViewModel() {
    private val _helpQuestionAnswerLiveData = MutableLiveData<List<HelpQuestionAnswerModel?>>()
    val helpQuestionAnswerLiveData: LiveData<List<HelpQuestionAnswerModel?>>
        get() = _helpQuestionAnswerLiveData

    fun getHelpQuestionAnswerList() = _helpQuestionAnswerLiveData.postValue(repository.getQuestionAnswerList())
}