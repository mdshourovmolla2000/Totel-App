package com.shourov.totel.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shourov.totel.R
import com.shourov.totel.databinding.SingleMessageItemLayoutBinding
import com.shourov.totel.interfaces.GuestMessageItemClickListener
import com.shourov.totel.model.MessageModel
import com.shourov.totel.utils.loadImage

class GuestMessageListAdapter(private var itemList: ArrayList<MessageModel?>, private val listener: GuestMessageItemClickListener) :
    RecyclerView.Adapter<GuestMessageListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_message_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = SingleMessageItemLayoutBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun onBind(currentItem: MessageModel?) {
            binding.profilePicImageview.loadImage(currentItem!!.profilePic)
            binding.userNameTextview.text = currentItem.userName
            binding.timeTextview.text = currentItem.messageTime
            binding.messageTextview.text = currentItem.message
            binding.newMessageCountTextview.text = currentItem.newMessageCount.toString()

            if (currentItem.newMessageCount!! > 0) {
                binding.newMessageCounter.visibility = View.VISIBLE
            } else {
                binding.newMessageCounter.visibility = View.GONE
            }

            itemView.setOnClickListener { listener.onItemClick(currentItem) }
        }
    }
}