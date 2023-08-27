package com.shourov.totel.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shourov.totel.R
import com.shourov.totel.databinding.SingleHostBookingItemLayoutBinding
import com.shourov.totel.model.BookingModel
import com.shourov.totel.utils.loadImage

class HostBookingsListAdapter(private var itemList: ArrayList<BookingModel?>) :
    RecyclerView.Adapter<HostBookingsListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_host_booking_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = SingleHostBookingItemLayoutBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun onBind(currentItem: BookingModel?) {
            binding.profilePictureImageview.loadImage(currentItem?.userProfilePic)
            binding.userNameTextview.text = currentItem?.userName
            binding.checkOutDateTextview.text = currentItem?.checkOutTime
            binding.checkInDateTextview.text = currentItem?.checkInTime
            binding.bookingStatusTextview.text = currentItem?.bookingStatus
            binding.priceTextview.text = currentItem?.price
        }
    }
}