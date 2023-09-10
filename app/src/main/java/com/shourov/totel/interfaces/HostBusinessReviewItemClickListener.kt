package com.shourov.totel.interfaces

import com.shourov.totel.model.HelpQuestionAnswerModel
import com.shourov.totel.model.HostBusinessReviewModel

interface HostBusinessReviewItemClickListener {
    fun onItemClick(currentItem: HostBusinessReviewModel?)
}