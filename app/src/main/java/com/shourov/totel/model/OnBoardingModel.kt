package com.shourov.totel.model

import com.shourov.totel.R

data class OnBoardingModel(
    val imageUrl: Int? = R.drawable.image_placeholder_square,
    val title: String? = "",
    val description: String? = "",
)