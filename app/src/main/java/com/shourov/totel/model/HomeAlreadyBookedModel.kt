package com.shourov.totel.model

import com.denzcoskun.imageslider.models.SlideModel

data class HomeAlreadyBookedModel(
    val profilePic: Int? = null,
    val userName: String? = null,
    val hotelLocation: String? = null,
    val sliderImageList: ArrayList<SlideModel>? = null,
    var hotelName: String? = null,
    val hotelDetailedLocation: String? = null,
    var date: String? = null,
    var price: String? = null
)
