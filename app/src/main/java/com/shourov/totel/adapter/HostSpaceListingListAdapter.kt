package com.shourov.totel.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.shourov.totel.R
import com.shourov.totel.databinding.SingleHostSpaceListingItemLayoutBinding
import com.shourov.totel.model.SpaceListingModel

class HostSpaceListingListAdapter(private var itemList: ArrayList<SpaceListingModel?>) :
    RecyclerView.Adapter<HostSpaceListingListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_host_space_listing_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = SingleHostSpaceListingItemLayoutBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun onBind(currentItem: SpaceListingModel?) {
            binding.imageSlider.setImageList(currentItem?.sliderImageList!!.toList(), ScaleTypes.CENTER_CROP)
            binding.hotelNameTextview.text = currentItem.hotelName
            binding.availableRoomCounterTextview.text = "${currentItem.availableRooms} rooms available"
            binding.ratingTextview.text = "(${currentItem.ratings})"
            binding.priceTextview.text = "${currentItem.price} / Night"
        }
    }
}