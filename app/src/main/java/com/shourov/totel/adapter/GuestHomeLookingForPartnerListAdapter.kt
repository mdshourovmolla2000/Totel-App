package com.shourov.totel.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.shourov.totel.R
import com.shourov.totel.databinding.SingleHomeLookingForPartnerItemLayoutBinding
import com.shourov.totel.model.HomeLookingForPartnerModel

class GuestHomeLookingForPartnerListAdapter(private var itemList: ArrayList<HomeLookingForPartnerModel?>) :
    RecyclerView.Adapter<GuestHomeLookingForPartnerListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_home_looking_for_partner_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = SingleHomeLookingForPartnerItemLayoutBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun onBind(currentItem: HomeLookingForPartnerModel?) {
            binding.imageSlider.setImageList(currentItem?.sliderImageList!!.toList(), ScaleTypes.CENTER_CROP)
            binding.nameTextview.text = currentItem.userName
            binding.addressTextview.text = currentItem.address
            binding.lookingPlacesTextview.text = "Looking Places: ${currentItem.lookingPlaces}"
            binding.availableDateTextview.text = "Available from ${currentItem.availableDate}"
            binding.budgetTextview.text = "Budget ${currentItem.availableDate}"
        }
    }
}