package com.shourov.totel.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.shourov.totel.R
import com.shourov.totel.databinding.SingleProfileAlreadyBookedItemLayoutBinding
import com.shourov.totel.model.ProfileAlreadyBookedModel

class ProfileAlreadyBookedListAdapter(private var itemList: ArrayList<ProfileAlreadyBookedModel?>) :
    RecyclerView.Adapter<ProfileAlreadyBookedListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_profile_already_booked_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = SingleProfileAlreadyBookedItemLayoutBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun onBind(currentItem: ProfileAlreadyBookedModel?) {
            binding.imageSlider.setImageList(currentItem!!.sliderImageList!!.toList(), ScaleTypes.CENTER_CROP)
            binding.hotelNameTextview.text = currentItem.hotelName
            if (currentItem.status == "Finished") {
                binding.noEncryptionIcon.visibility = View.VISIBLE
                binding.statusButton.text = "Finished"
                binding.statusButton.visibility = View.VISIBLE
            } else {
                binding.noEncryptionIcon.visibility = View.GONE
                binding.statusButton.visibility = View.GONE
            }
            binding.hotelLocationTextview.text = currentItem.hotelLocation
            binding.lookingPlacesTextview.text = "Looking Places: ${currentItem.hotelLocation}"
            binding.dateTextview.text = currentItem.date
            binding.priceTextview.text = currentItem.price
        }
    }
}