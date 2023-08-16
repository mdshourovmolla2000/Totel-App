package com.shourov.totel.repository

import com.shourov.totel.model.ProfileAlreadyBookedModel
import com.shourov.totel.utils.DemoData

class GuestProfileRepository {
    fun getProfileAlreadyBookedList(): List<ProfileAlreadyBookedModel?> = DemoData().profileAlreadyBookedData()
}