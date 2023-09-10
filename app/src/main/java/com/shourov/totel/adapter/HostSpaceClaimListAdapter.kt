package com.shourov.totel.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shourov.totel.R
import com.shourov.totel.databinding.SingleHostSpaceClaimsItemLayoutBinding
import com.shourov.totel.model.SpaceClaimModel
import com.shourov.totel.utils.loadImage

class HostSpaceClaimListAdapter(private var itemList: ArrayList<SpaceClaimModel?>) :
    RecyclerView.Adapter<HostSpaceClaimListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_host_space_claims_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = SingleHostSpaceClaimsItemLayoutBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun onBind(currentItem: SpaceClaimModel?) {
            binding.hotelPicImageview.loadImage(currentItem!!.hotelImage)
            binding.hotelNameTextview.text = currentItem.hotelName
            binding.hotelDetailsTextview.text = currentItem.hotelDetails
            binding.chargeTextview.text = "Charges ${currentItem.charge}"
        }
    }
}