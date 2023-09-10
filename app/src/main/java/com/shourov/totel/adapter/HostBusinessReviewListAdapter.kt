package com.shourov.totel.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shourov.totel.R
import com.shourov.totel.databinding.SingleHostBusinessReviewsItemLayoutBinding
import com.shourov.totel.interfaces.HostBusinessReviewItemClickListener
import com.shourov.totel.model.HostBusinessReviewModel
import com.shourov.totel.utils.loadImage

class HostBusinessReviewListAdapter(private var itemList: ArrayList<HostBusinessReviewModel?>, private val listener: HostBusinessReviewItemClickListener) :
    RecyclerView.Adapter<HostBusinessReviewListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_host_business_reviews_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = SingleHostBusinessReviewsItemLayoutBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun onBind(currentItem: HostBusinessReviewModel?) {
            binding.profilePicImageview.loadImage(currentItem!!.userProfilePicture)
            binding.userNameTextview.text = currentItem.userName
            binding.ratingTextview.text = "(${currentItem.rating})"
            binding.bookingNoTextview.text = "Booking No : ${currentItem.bookingNo}"
            binding.detailsTextview.text = currentItem.details
            binding.visitorCountTextview.text = currentItem.visitorCount.toString()
            binding.shareCountTextview.text = currentItem.shareCount.toString()
            binding.dateTimeTextview.text = currentItem.dateTime

            if (currentItem.isClicked == true) {
                binding.arrowIcon.loadImage(R.drawable.down_arrow_white)
                binding.detailsSectionLayout.visibility = View.VISIBLE
            } else {
                binding.arrowIcon.loadImage(R.drawable.up_arrow_white)
                binding.detailsSectionLayout.visibility = View.GONE
            }

            binding.arrowIconLayout.setOnClickListener { listener.onItemClick(currentItem) }
        }
    }
}