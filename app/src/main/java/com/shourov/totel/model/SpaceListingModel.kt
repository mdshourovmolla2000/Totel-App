package com.shourov.totel.model

import com.denzcoskun.imageslider.models.SlideModel

data class SpaceListingModel(
    val sliderImageList: ArrayList<SlideModel>? = null,
    val hotelName: String? = null,
    val availableRooms: Int? = null,
    var ratings: Double? = null,
    val price: String? = null
)
