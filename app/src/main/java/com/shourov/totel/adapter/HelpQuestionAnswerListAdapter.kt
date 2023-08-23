package com.shourov.totel.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shourov.totel.R
import com.shourov.totel.databinding.SingleHelpQuestionAnswerItemLayoutBinding
import com.shourov.totel.interfaces.HelpQuestionAnswerItemClickListener
import com.shourov.totel.model.HelpQuestionAnswerModel
import com.shourov.totel.utils.loadImage

class HelpQuestionAnswerListAdapter(private var itemList: ArrayList<HelpQuestionAnswerModel?>, private val listener: HelpQuestionAnswerItemClickListener) :
    RecyclerView.Adapter<HelpQuestionAnswerListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_help_question_answer_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = SingleHelpQuestionAnswerItemLayoutBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun onBind(currentItem: HelpQuestionAnswerModel?) {
            binding.questionTextview.text = currentItem?.question
            binding.answerTextview.text = currentItem?.answer

            if (currentItem?.isClicked == true) {
                binding.arrowIcon.loadImage(R.drawable.help_question_arrow_down)
                binding.answerTextview.visibility = View.VISIBLE
            } else {
                binding.arrowIcon.loadImage(R.drawable.help_question_arrow_up)
                binding.answerTextview.visibility = View.GONE
            }

            binding.questionButton.setOnClickListener { listener.onItemClick(currentItem) }
        }
    }
}