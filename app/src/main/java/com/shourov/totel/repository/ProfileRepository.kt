package com.shourov.totel.repository

import com.shourov.totel.model.ProfileAlreadyBookedModel
import com.shourov.totel.utils.DemoData

class ProfileRepository {
    fun getProfileAlreadyBookedList(): List<ProfileAlreadyBookedModel?> = DemoData().profileAlreadyBookedData()
}