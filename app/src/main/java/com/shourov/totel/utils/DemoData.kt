package com.shourov.totel.utils

import com.denzcoskun.imageslider.models.SlideModel
import com.shourov.totel.R
import com.shourov.totel.model.HobbyModel
import com.shourov.totel.model.HomeAlreadyBookedModel
import com.shourov.totel.model.NotificationModel
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

    fun hobbiesData(): List<HobbyModel>{
        val itemList: ArrayList<HobbyModel> = ArrayList()
        itemList.add(HobbyModel("Cooking"))
        itemList.add(HobbyModel("Learning Languages"))
        itemList.add(HobbyModel("Music"))
        itemList.add(HobbyModel("Gym"))
        itemList.add(HobbyModel("Photography"))
        itemList.add(HobbyModel("Travel"))
        itemList.add(HobbyModel("Art"))
        itemList.add(HobbyModel("Swimming"))
        itemList.add(HobbyModel("Playing Games"))
        itemList.add(HobbyModel("Sports"))
        itemList.add(HobbyModel("Travel"))
        itemList.add(HobbyModel("Sports"))
        itemList.add(HobbyModel("Dance"))
        return itemList
    }

    fun notificationData(): List<NotificationModel> {
        val itemList: ArrayList<NotificationModel> = ArrayList()
        itemList.add(NotificationModel(R.drawable.notification_profile_pic_1, "Now you can give a review to stella_sf’s place", "5 Min Ago", R.drawable.notification_image_1, "Today"))
        itemList.add(NotificationModel(R.drawable.notification_profile_pic_2, "sugeevan_svg & jamestalan send you a proposal.", "Just now", R.drawable.notification_image_2, "Today"))
        itemList.add(NotificationModel(R.drawable.notification_profile_pic_3, "stella_sf Send you a proposal.", "5 Min Ago", R.drawable.notification_image_3, "Today"))
        itemList.add(NotificationModel(R.drawable.notification_profile_pic_1, "maria_2 give you a review: @konsikan exactly..", "28 Min Ago", R.drawable.notification_image_4, "Today"))
        itemList.add(NotificationModel(R.drawable.notification_profile_pic_2, "starelli_kw give you a review: @konsikan exactly..", "Just now", R.drawable.notification_image_1, "This Week"))
        itemList.add(NotificationModel(R.drawable.notification_profile_pic_3, "sugeevan_svg & jamestalan send you a proposal.", "23 March, 2023", R.drawable.notification_image_2, "This Month"))
        itemList.add(NotificationModel(R.drawable.notification_profile_pic_1, "stella_sf Send you a proposal.", "18 March, 2023", R.drawable.notification_image_3, "This Month"))
        itemList.add(NotificationModel(R.drawable.notification_profile_pic_2, "maria_2 give you a review: @konsikan exactly..", "12 March, 2023", R.drawable.notification_image_4, "This Month"))
        itemList.add(NotificationModel(R.drawable.notification_profile_pic_3, "sugeevan_svg & jamestalan send you a proposal.", "23 March, 2022", R.drawable.notification_image_1, "Earlier"))
        itemList.add(NotificationModel(R.drawable.notification_profile_pic_1, "stella_sf Send you a proposal.", "18 March, 2022", R.drawable.notification_image_2, "Earlier"))
        itemList.add(NotificationModel(R.drawable.notification_profile_pic_2, "maria_2 give you a review: @konsikan exactly..", "12 March, 2022", R.drawable.notification_image_3, "Earlier"))
        return itemList
    }
}