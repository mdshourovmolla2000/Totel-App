package com.shourov.totel.interfaces

import com.shourov.totel.model.MessageModel

interface MessageItemClickListener {
    fun onItemClick(currentItem: MessageModel)
}