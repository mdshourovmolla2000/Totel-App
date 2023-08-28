package com.shourov.totel.utils

import com.denzcoskun.imageslider.models.SlideModel
import com.shourov.totel.R
import com.shourov.totel.model.BookingModel
import com.shourov.totel.model.HelpQuestionAnswerModel
import com.shourov.totel.model.HobbyModel
import com.shourov.totel.model.HomeAlreadyBookedModel
import com.shourov.totel.model.HomeLookingForPartnerModel
import com.shourov.totel.model.MessageModel
import com.shourov.totel.model.NotificationModel
import com.shourov.totel.model.OnBoardingModel
import com.shourov.totel.model.ProfileAlreadyBookedModel

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

    fun homeLookingForPartnerData(): List<HomeLookingForPartnerModel> {
        val itemList: ArrayList<HomeLookingForPartnerModel> = ArrayList()
        itemList.add(
            HomeLookingForPartnerModel(arrayListOf(
            SlideModel(R.drawable.home_looking_for_partner_profile_1),
            SlideModel(R.drawable.home_looking_for_partner_profile_2),
            SlideModel(R.drawable.home_looking_for_partner_profile_3)
            ), "Alex Norman", "Great Western Dockyard, Gas Ferry Rd, Bristol BS1 6TY", "Bristol, Bath & London", "20th March, 2023", "\$650-\$800")
        )
        itemList.add(
            HomeLookingForPartnerModel(arrayListOf(
                SlideModel(R.drawable.home_looking_for_partner_profile_2),
                SlideModel(R.drawable.home_looking_for_partner_profile_3),
                SlideModel(R.drawable.home_looking_for_partner_profile_1)
            ), "Alex Norman", "Great Western Dockyard, Gas Ferry Rd, Bristol BS1 6TY", "Bristol, Bath & London", "20th March, 2023", "\$650-\$800")
        )
        itemList.add(
            HomeLookingForPartnerModel(arrayListOf(
                SlideModel(R.drawable.home_looking_for_partner_profile_3),
                SlideModel(R.drawable.home_looking_for_partner_profile_1),
                SlideModel(R.drawable.home_looking_for_partner_profile_2)
            ), "Alex Norman", "Great Western Dockyard, Gas Ferry Rd, Bristol BS1 6TY", "Bristol, Bath & London", "20th March, 2023", "\$650-\$800")
        )
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

    fun profileAlreadyBookedData(): List<ProfileAlreadyBookedModel> {
        val itemList: ArrayList<ProfileAlreadyBookedModel> = ArrayList()
        itemList.add(
            ProfileAlreadyBookedModel(arrayListOf(
            SlideModel(R.drawable.home_already_booked_hotel_pic_1),
            SlideModel(R.drawable.home_already_booked_hotel_pic_2),
            SlideModel(R.drawable.home_already_booked_hotel_pic_3)
        ), "Brunel's SS Great Britain", "Great Western Dockyard, Gas Ferry Rd, Bristol BS1 6TY", "Bristol, Bath & London", "25 Jan - 27 Jan", "\$650/Night", null)
        )
        itemList.add(
            ProfileAlreadyBookedModel(arrayListOf(
                SlideModel(R.drawable.home_already_booked_hotel_pic_1),
                SlideModel(R.drawable.home_already_booked_hotel_pic_2),
                SlideModel(R.drawable.home_already_booked_hotel_pic_3)
            ), "Brunel's SS Great Britain", "Great Western Dockyard, Gas Ferry Rd, Bristol BS1 6TY", "Bristol, Bath & London", "25 Jan - 27 Jan", "\$650/Night", "Finished")
        )
        return itemList
    }

    fun messageData(): List<MessageModel> {
        val itemList: ArrayList<MessageModel> = ArrayList()
        itemList.add(MessageModel(R.drawable.notification_profile_pic_1, "Stella Marium", "3:29 PM", "Where are you now? I’m waiting for your room key", 2))
        itemList.add(MessageModel(R.drawable.notification_profile_pic_1, "Stella Marium", "3:29 PM", "Where are you now? I’m waiting for your room key", 2))
        itemList.add(MessageModel(R.drawable.notification_profile_pic_1, "Stella Marium", "3:29 PM", "Where are you now? I’m waiting for your room key", 2))
        itemList.add(MessageModel(R.drawable.notification_profile_pic_1, "Stella Marium", "3:29 PM", "Where are you now? I’m waiting for your room key", 0))
        itemList.add(MessageModel(R.drawable.notification_profile_pic_1, "Stella Marium", "3:29 PM", "Where are you now? I’m waiting for your room key", 0))
        itemList.add(MessageModel(R.drawable.notification_profile_pic_1, "Stella Marium", "3:29 PM", "Where are you now? I’m waiting for your room key", 0))
        return itemList
    }

    fun helpHotelBookingQuestionAnswerData(): List<HelpQuestionAnswerModel> {
        val itemList: ArrayList<HelpQuestionAnswerModel> = ArrayList()
        itemList.add(HelpQuestionAnswerModel("Finding and selecting a hotel ", "In this step, we'll ask you which type of stays you have and if guests will book the entire place or just a room. ", false))
        itemList.add(HelpQuestionAnswerModel("Checking hotel amenities and facilities", "In this step, we'll ask you which type of stays you have and if guests will book the entire place or just a room. ", false))
        itemList.add(HelpQuestionAnswerModel("Understanding hotel policies", "In this step, we'll ask you which type of stays you have and if guests will book the entire place or just a room. ", false))
        itemList.add(HelpQuestionAnswerModel("Exploring nearby attractions and activities", "In this step, we'll ask you which type of stays you have and if guests will book the entire place or just a room. ", false))
        itemList.add(HelpQuestionAnswerModel("Best time to book a hotel", "In this step, we'll ask you which type of stays you have and if guests will book the entire place or just a room. ", false))
        itemList.add(HelpQuestionAnswerModel("Making a reservation", "In this step, we'll ask you which type of stays you have and if guests will book the entire place or just a room. ", false))
        itemList.add(HelpQuestionAnswerModel("Cancelling or modifying a reservation", "In this step, we'll ask you which type of stays you have and if guests will book the entire place or just a room. ", false))
        itemList.add(HelpQuestionAnswerModel("Loyalty programs and hotel rewards", "In this step, we'll ask you which type of stays you have and if guests will book the entire place or just a room. ", false))
        itemList.add(HelpQuestionAnswerModel("Safety and security", "In this step, we'll ask you which type of stays you have and if guests will book the entire place or just a room. ", false))
        itemList.add(HelpQuestionAnswerModel("Special requests and accommodations", "In this step, we'll ask you which type of stays you have and if guests will book the entire place or just a room. ", false))
        itemList.add(HelpQuestionAnswerModel("Hotel reviews and ratings", "In this step, we'll ask you which type of stays you have and if guests will book the entire place or just a room. ", false))
        return itemList
    }

    fun hostBookingsBookedData(): List<BookingModel> {
        val itemList: ArrayList<BookingModel> = ArrayList()
        itemList.add(BookingModel(1, R.drawable.host_booking_booked_profile_pic, "Jacky Shopy", "28 Apr 2022 - 10.00 AM", "25 Apr 2022 - 2.00 PM", "Booking completed", "32\$/Day"))
        itemList.add(BookingModel(2, R.drawable.host_booking_booked_profile_pic, "Jacky Shopy", "28 Apr 2022 - 10.00 AM", "25 Apr 2022 - 2.00 PM", "Booking completed", "32\$/Day"))
        itemList.add(BookingModel(3, R.drawable.host_booking_booked_profile_pic, "Jacky Shopy", "28 Apr 2022 - 10.00 AM", "25 Apr 2022 - 2.00 PM", "Booking completed", "32\$/Day"))
        itemList.add(BookingModel(4, R.drawable.host_booking_booked_profile_pic, "Jacky Shopy", "28 Apr 2022 - 10.00 AM", "25 Apr 2022 - 2.00 PM", "Booking completed", "32\$/Day"))
        itemList.add(BookingModel(5, R.drawable.host_booking_booked_profile_pic, "Jacky Shopy", "28 Apr 2022 - 10.00 AM", "25 Apr 2022 - 2.00 PM", "Booking completed", "32\$/Day"))
        itemList.add(BookingModel(6, R.drawable.host_booking_booked_profile_pic, "Jacky Shopy", "28 Apr 2022 - 10.00 AM", "25 Apr 2022 - 2.00 PM", "Booking completed", "32\$/Day"))
        itemList.add(BookingModel(7, R.drawable.host_booking_booked_profile_pic, "Jacky Shopy", "28 Apr 2022 - 10.00 AM", "25 Apr 2022 - 2.00 PM", "Booking completed", "32\$/Day"))
        itemList.add(BookingModel(8, R.drawable.host_booking_booked_profile_pic, "Jacky Shopy", "28 Apr 2022 - 10.00 AM", "25 Apr 2022 - 2.00 PM", "Booking completed", "32\$/Day"))
        return itemList
    }

    fun hostBookingsHistoryData(): List<BookingModel> {
        val itemList: ArrayList<BookingModel> = ArrayList()
        itemList.add(BookingModel(1, R.drawable.host_booking_history_profile_pic, "Jacky Shopy", "28 Apr 2022 - 10.00 AM", "25 Apr 2022 - 2.00 PM", "Booking completed", "32\$/Day"))
        itemList.add(BookingModel(2, R.drawable.host_booking_history_profile_pic, "Jacky Shopy", "28 Apr 2022 - 10.00 AM", "25 Apr 2022 - 2.00 PM", "Booking completed", "32\$/Day"))
        itemList.add(BookingModel(3, R.drawable.host_booking_history_profile_pic, "Jacky Shopy", "28 Apr 2022 - 10.00 AM", "25 Apr 2022 - 2.00 PM", "Booking completed", "32\$/Day"))
        itemList.add(BookingModel(4, R.drawable.host_booking_history_profile_pic, "Jacky Shopy", "28 Apr 2022 - 10.00 AM", "25 Apr 2022 - 2.00 PM", "Booking completed", "32\$/Day"))
        itemList.add(BookingModel(5, R.drawable.host_booking_history_profile_pic, "Jacky Shopy", "28 Apr 2022 - 10.00 AM", "25 Apr 2022 - 2.00 PM", "Booking completed", "32\$/Day"))
        itemList.add(BookingModel(6, R.drawable.host_booking_history_profile_pic, "Jacky Shopy", "28 Apr 2022 - 10.00 AM", "25 Apr 2022 - 2.00 PM", "Booking completed", "32\$/Day"))
        itemList.add(BookingModel(7, R.drawable.host_booking_history_profile_pic, "Jacky Shopy", "28 Apr 2022 - 10.00 AM", "25 Apr 2022 - 2.00 PM", "Booking completed", "32\$/Day"))
        itemList.add(BookingModel(8, R.drawable.host_booking_history_profile_pic, "Jacky Shopy", "28 Apr 2022 - 10.00 AM", "25 Apr 2022 - 2.00 PM", "Booking completed", "32\$/Day"))
        return itemList
    }
}