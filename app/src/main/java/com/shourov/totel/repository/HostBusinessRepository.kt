package com.shourov.totel.repository

import com.shourov.totel.model.HostBusinessReviewModel
import com.shourov.totel.utils.DemoData

class HostBusinessRepository {
    fun getReviewList(): List<HostBusinessReviewModel?> = DemoData().hostBusinessReviewData()
}