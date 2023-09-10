package com.shourov.totel.repository

import com.shourov.totel.model.SpaceClaimModel
import com.shourov.totel.model.SpaceListingModel
import com.shourov.totel.utils.DemoData

class HostSpaceRepository {
    fun getSpaceListingList(): List<SpaceListingModel?> = DemoData().hostSpaceListingData()

    fun getSpaceClaimList(): List<SpaceClaimModel?> = DemoData().hostSpaceClaimData()
}