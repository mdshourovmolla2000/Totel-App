package com.shourov.totel.utils

import com.denzcoskun.imageslider.models.SlideModel
import com.shourov.totel.R
import com.shourov.totel.model.HomeAlreadyBookedModel
import com.shourov.totel.model.OnBoardingModel

class DemoData {
    fun onBoardingData(): List<OnBoardingModel> {
        val itemList: ArrayList<OnBoardingModel> = ArrayList()
        itemList.add(OnBoardingModel(R.drawable.onboarding_image_1, "Shared living space", "What fun could we have more than having roommate with similar interest."))
        itemList.add(OnBoardingModel(R.drawable.onboarding_image_2, "Find places around you", "You can find places and stay with hotels and home-stays ranked by travellers."))
        itemList.add(OnBoardingModel(R.drawable.onboarding_image_3, "Find places around you", "You can find places and stay with hotels and home-stays ranked by travellers."))
        return itemList
    }

    fun homeAlreadyBookedData(): List<HomeAlreadyBookedModel> {
        val itemList: ArrayList<HomeAlreadyBookedModel> = ArrayList()
        itemList.add(HomeAlreadyBookedModel(R.drawable.home_already_booked_user_profile_pic_1, "Michealy Dam", "CA, United States.", arrayListOf(
            SlideModel(R.drawable.home_already_booked_hotel_pic_1),
            SlideModel(R.drawable.home_already_booked_hotel_pic_2),
            SlideModel(R.drawable.home_already_booked_hotel_pic_3)
        ), "Brunel's SS Great Britain", "Great Western Dockyard, Gas Ferry Rd, Bristol BS1 6TY", "25 Jan - 27 Jan", "\$650/Night"))
        itemList.add(HomeAlreadyBookedModel(R.drawable.home_already_booked_user_profile_pic_2, "Alex Norman", "CA, United States.", arrayListOf(
            SlideModel(R.drawable.home_already_booked_hotel_pic_2),
            SlideModel(R.drawable.home_already_booked_hotel_pic_3),
            SlideModel(R.drawable.home_already_booked_hotel_pic_1)
        ), "Brunel's SS Great Britain", "Great Western Dockyard, Gas Ferry Rd, Bristol BS1 6TY", "25 Jan - 27 Jan", "\$650/Night"))
        itemList.add(HomeAlreadyBookedModel(R.drawable.home_already_booked_user_profile_pic_3, "Michealy Dam", "CA, United States.", arrayListOf(
            SlideModel(R.drawable.home_already_booked_hotel_pic_3),
            SlideModel(R.drawable.home_already_booked_hotel_pic_1),
            SlideModel(R.drawable.home_already_booked_hotel_pic_2)
        ), "Brunel's SS Great Britain", "Great Western Dockyard, Gas Ferry Rd, Bristol BS1 6TY", "25 Jan - 27 Jan", "\$650/Night"))
        return itemList
    }
}