package com.shourov.totel.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shourov.totel.R
import com.shourov.totel.databinding.SingleHobbyItemBinding
import com.shourov.totel.interfaces.HobbyItemClickListener
import com.shourov.totel.model.HobbyModel

class HobbyListAdapter(private var itemList: ArrayList<HobbyModel>, private val listener: HobbyItemClickListener):
    RecyclerView.Adapter<HobbyListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_hobby_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = SingleHobbyItemBinding.bind(itemView)

        fun onBind(currentItem: HobbyModel) {
            binding.itemButton.text = currentItem.hobby

            if (currentItem.isSelected) {
                binding.itemButton.background.setTint(Color.parseColor("#000000"))
                binding.itemButton.setTextColor(Color.parseColor("#FFFFFF"))
            } else {
                binding.itemButton.background.setTint(Color.parseColor("#99EBEBF5"))
                binding.itemButton.setTextColor(Color.parseColor("#000000"))
            }

            itemView.setOnClickListener {
                listener.onItemClick(currentItem)
            }
        }

    }
}