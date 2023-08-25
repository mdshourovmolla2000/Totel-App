package com.shourov.totel.model

import com.denzcoskun.imageslider.models.SlideModel

data class HomeLookingForPartnerModel(
    val sliderImageList: ArrayList<SlideModel>? = null,
    val userName: String? = null,
    val address: String? = null,
    var lookingPlaces: String? = null,
    val availableDate: String? = null,
    var budget: String? = null,
    var status: String? = null
)
