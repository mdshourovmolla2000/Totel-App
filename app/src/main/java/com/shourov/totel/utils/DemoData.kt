package com.shourov.totel.utils

import com.shourov.totel.R
import com.shourov.totel.model.OnBoardingModel

class DemoData {
    fun onBoardingData(): List<OnBoardingModel> {
        val itemList: ArrayList<OnBoardingModel> = ArrayList()
        itemList.add(OnBoardingModel(R.drawable.onboarding_image_1, "Shared living space", "What fun could we have more than having roommate with similar interest."))
        itemList.add(OnBoardingModel(R.drawable.onboarding_image_2, "Find places around you", "You can find places and stay with hotels and home-stays ranked by travellers."))
        itemList.add(OnBoardingModel(R.drawable.onboarding_image_3, "Find places around you", "You can find places and stay with hotels and home-stays ranked by travellers."))
        return itemList
    }
}