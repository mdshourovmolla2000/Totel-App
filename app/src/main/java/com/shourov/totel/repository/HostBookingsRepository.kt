package com.shourov.totel.repository

import com.shourov.totel.model.BookingModel
import com.shourov.totel.utils.DemoData

class HostBookingsRepository {
    fun getBookingsBookedList(): List<BookingModel?> = DemoData().hostBookingsBookedData()
}