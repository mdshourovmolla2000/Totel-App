package com.shourov.totel.repository

import com.shourov.totel.model.HobbyModel
import com.shourov.totel.utils.DemoData

class CreateAccountHobbiesRepository {
    fun getHobbiesList(): List<HobbyModel> = DemoData().hobbiesData()
}