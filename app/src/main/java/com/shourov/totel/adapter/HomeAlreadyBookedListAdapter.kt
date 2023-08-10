package com.shourov.totel.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.shourov.totel.R
import com.shourov.totel.databinding.SingleHomeAlreadyBookedItemLayoutBinding
import com.shourov.totel.model.HomeAlreadyBookedModel
import com.shourov.totel.utils.loadImage

class HomeAlreadyBookedListAdapter(private var itemList: ArrayList<HomeAlreadyBookedModel?>) :
    RecyclerView.Adapter<HomeAlreadyBookedListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_home_already_booked_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = SingleHomeAlreadyBookedItemLayoutBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun onBind(currentItem: HomeAlreadyBookedModel?) {
            binding.profilePicImageview.loadImage(currentItem!!.profilePic)
            binding.nameTextview.text = currentItem.hotelName
            binding.locationTextview.text = currentItem.hotelLocation
            binding.imageSlider.setImageList(currentItem.sliderImageList!!.toList(), ScaleTypes.CENTER_CROP)
            binding.hotelNameTextview.text = currentItem.hotelName
            binding.detailedLocationTextview.text = currentItem.hotelDetailedLocation
            binding.dateTextview.text = currentItem.date
            binding.priceTextview.text = currentItem.price
        }
    }
}