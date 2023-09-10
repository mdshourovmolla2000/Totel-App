package com.shourov.totel.view.host_activity.profile_screen.account_sub_section.business_screen

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.adapter.HostBusinessReviewListAdapter
import com.shourov.totel.databinding.FragmentHostBusinessBinding
import com.shourov.totel.interfaces.HostBusinessReviewItemClickListener
import com.shourov.totel.model.HostBusinessReviewModel
import com.shourov.totel.repository.HostBusinessRepository
import com.shourov.totel.view_model.HostBusinessViewModel

class HostBusinessFragment : Fragment(), HostBusinessReviewItemClickListener {

    private lateinit var binding: FragmentHostBusinessBinding

    private lateinit var viewModel: HostBusinessViewModel

    private val reviewList = ArrayList<HostBusinessReviewModel?>()

    private var currentlySelected = "EARNINGS"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHostBusinessBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, HostBusinessViewModelFactory(HostBusinessRepository()))[HostBusinessViewModel::class.java]

        viewModel.getReviewList()

        observerList()

        updateView()

        binding.backIcon.setOnClickListener { findNavController().popBackStack() }

        binding.reviewsListRecyclerview.adapter = HostBusinessReviewListAdapter(reviewList, this)

        binding.earningsButton.setOnClickListener {
            if (currentlySelected != "EARNINGS") {
                currentlySelected = "EARNINGS"
                updateView()
            }
        }

        binding.reviewsButton.setOnClickListener {
            if (currentlySelected != "REVIEWS") {
                currentlySelected = "REVIEWS"
                updateView()
            }
        }

        return binding.root
    }

    private fun observerList(){
        viewModel.reviewListLiveData.observe(viewLifecycleOwner) {
            it?.let {
                reviewList.clear()
                reviewList.addAll(it)
                binding.reviewsListRecyclerview.adapter?.notifyDataSetChanged()
            }
        }
    }

    private fun updateView() {
        binding.earningsButton.background = null
        binding.reviewsButton.background = null
        binding.earningsButton.setTextColor(Color.parseColor("#3F3F3F"))
        binding.reviewsButton.setTextColor(Color.parseColor("#3F3F3F"))
        binding.earningsSectionLayout.visibility = View.GONE
        binding.reviewsSectionLayout.visibility = View.GONE

        when(currentlySelected) {
            "EARNINGS" -> {
                binding.earningsSectionLayout.visibility = View.VISIBLE
                binding.earningsButton.background = ContextCompat.getDrawable(requireContext(), R.drawable.host_bg_end_rounded)
                binding.earningsButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.themeColor))
            }
            "REVIEWS" -> {
                binding.reviewsSectionLayout.visibility = View.VISIBLE
                binding.reviewsButton.background = ContextCompat.getDrawable(requireContext(), R.drawable.host_bg_start_rounded)
                binding.reviewsButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.themeColor))
            }
        }
    }

    override fun onItemClick(currentItem: HostBusinessReviewModel?) {
        reviewList.forEach {
            if (it != currentItem) {
                it?.isClicked = false
            }
        }
        currentItem?.isClicked = !(currentItem?.isClicked)!!

        binding.reviewsListRecyclerview.adapter?.notifyDataSetChanged()
    }
}




class HostBusinessViewModelFactory(private val repository: HostBusinessRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = HostBusinessViewModel(repository) as T
}