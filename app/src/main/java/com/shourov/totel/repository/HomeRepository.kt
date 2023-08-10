package com.shourov.totel.repository

import com.shourov.totel.model.HomeAlreadyBookedModel
import com.shourov.totel.utils.DemoData

class HomeRepository {
    fun getHomeAlreadyBookedList(): List<HomeAlreadyBookedModel?> = DemoData().homeAlreadyBookedData()
}