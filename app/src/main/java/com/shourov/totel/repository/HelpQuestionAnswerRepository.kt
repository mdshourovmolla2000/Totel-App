package com.shourov.totel.repository

import com.shourov.totel.model.HelpQuestionAnswerModel
import com.shourov.totel.utils.DemoData

class HelpQuestionAnswerRepository {
    fun getQuestionAnswerList(): List<HelpQuestionAnswerModel?> = DemoData().helpHotelBookingQuestionAnswerData()
}