package com.shourov.totel.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shourov.totel.model.BookingModel
import com.shourov.totel.repository.HostBookingsRepository

class HostBookingsViewModel(private val repository: HostBookingsRepository) : ViewModel() {
    private val _bookingsBookedListLiveData = MutableLiveData<List<BookingModel?>>()
    val bookingsBookedListLiveData: LiveData<List<BookingModel?>>
        get() = _bookingsBookedListLiveData

    fun getBookingsBookedList() = _bookingsBookedListLiveData.postValue(repository.getBookingsBookedList())

    private val _bookingsHistoryListLiveData = MutableLiveData<List<BookingModel?>>()
    val bookingsHistoryListLiveData: LiveData<List<BookingModel?>>
        get() = _bookingsHistoryListLiveData

    fun getBookingsHistoryList() = _bookingsHistoryListLiveData.postValue(repository.getBookingsHistoryList())
}