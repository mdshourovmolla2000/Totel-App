package com.shourov.totel.model

import com.denzcoskun.imageslider.models.SlideModel

data class ProfileAlreadyBookedModel(
    val sliderImageList: ArrayList<SlideModel>? = null,
    var hotelName: String? = null,
    val hotelLocation: String? = null,
    val lookingPlaces: String? = null,
    var date: String? = null,
    var price: String? = null,
    var status: String? = null
)
