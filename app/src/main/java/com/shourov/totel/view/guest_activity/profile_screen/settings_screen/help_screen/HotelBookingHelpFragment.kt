package com.shourov.totel.view.guest_activity.profile_screen.settings_screen.help_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shourov.totel.adapter.HelpQuestionAnswerListAdapter
import com.shourov.totel.databinding.FragmentHotelBookingHelpBinding
import com.shourov.totel.interfaces.HelpQuestionAnswerItemClickListener
import com.shourov.totel.model.HelpQuestionAnswerModel
import com.shourov.totel.repository.HelpQuestionAnswerRepository
import com.shourov.totel.view_model.HelpQuestionAnswerViewModel

class HotelBookingHelpFragment : Fragment(), HelpQuestionAnswerItemClickListener {

    private lateinit var binding: FragmentHotelBookingHelpBinding

    private lateinit var viewModel: HelpQuestionAnswerViewModel

    private val questionAnswerList = ArrayList<HelpQuestionAnswerModel?>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHotelBookingHelpBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, HotelBookingHelpViewModelFactory(
            HelpQuestionAnswerRepository()
        ))[HelpQuestionAnswerViewModel::class.java]

        viewModel.getHelpQuestionAnswerList()

        observerList()

        binding.questionAnswerRecyclerview.adapter = HelpQuestionAnswerListAdapter(questionAnswerList, this)

        return binding.root
    }

    private fun observerList(){
        viewModel.helpQuestionAnswerLiveData.observe(viewLifecycleOwner) {
            questionAnswerList.clear()
            questionAnswerList.addAll(it)
            binding.questionAnswerRecyclerview.adapter?.notifyDataSetChanged()
        }
    }

    override fun onItemClick(currentItem: HelpQuestionAnswerModel?) {
        questionAnswerList.forEach {
            if (it != currentItem) {
                it?.isClicked = false
            }
        }
        currentItem?.isClicked = !(currentItem?.isClicked)!!

        binding.questionAnswerRecyclerview.adapter?.notifyDataSetChanged()
    }
}




class HotelBookingHelpViewModelFactory(private val repository: HelpQuestionAnswerRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = HelpQuestionAnswerViewModel(repository) as T
}