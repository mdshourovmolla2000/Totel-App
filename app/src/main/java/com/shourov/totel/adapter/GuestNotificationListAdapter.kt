package com.shourov.totel.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shourov.totel.R
import com.shourov.totel.databinding.SingleNotificationItemLayoutBinding
import com.shourov.totel.model.NotificationModel
import com.shourov.totel.utils.loadImage

class GuestNotificationListAdapter(private var itemList: ArrayList<NotificationModel?>) :
    RecyclerView.Adapter<GuestNotificationListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_notification_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = SingleNotificationItemLayoutBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun onBind(currentItem: NotificationModel?) {
            binding.profilePicImageview.loadImage(currentItem!!.profilePic)
            binding.notificationMessageTextview.text = currentItem.notificationMessage
            binding.notificationTimeTextview.text = currentItem.notificationTime
            binding.notificationImage.loadImage(currentItem.notificationImage)
        }
    }
}