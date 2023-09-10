package com.shourov.totel.view.host_activity.profile_screen.account_sub_section.space_screen

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
import com.shourov.totel.adapter.HostSpaceClaimListAdapter
import com.shourov.totel.adapter.HostSpaceListingListAdapter
import com.shourov.totel.databinding.FragmentHostSpaceBinding
import com.shourov.totel.model.SpaceClaimModel
import com.shourov.totel.model.SpaceListingModel
import com.shourov.totel.repository.HostSpaceRepository
import com.shourov.totel.view_model.HostSpaceViewModel

class HostSpaceFragment : Fragment() {

    private lateinit var binding: FragmentHostSpaceBinding

    private lateinit var viewModel: HostSpaceViewModel

    private val spaceListingList = ArrayList<SpaceListingModel?>()
    private val spaceClaimList = ArrayList<SpaceClaimModel?>()

    private var currentlySelected = "LISTINGS"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHostSpaceBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, HostSpaceViewModelFactory(HostSpaceRepository()))[HostSpaceViewModel::class.java]

        viewModel.getSpaceListingList()
        viewModel.getSpaceClaimList()

        observerList()

        updateView()

        binding.backIcon.setOnClickListener { findNavController().popBackStack() }

        binding.listingsListRecyclerview.adapter = HostSpaceListingListAdapter(spaceListingList)
        binding.claimsListRecyclerview.adapter = HostSpaceClaimListAdapter(spaceClaimList)

        binding.listingsButton.setOnClickListener {
            if (currentlySelected != "LISTINGS") {
                currentlySelected = "LISTINGS"
                updateView()
            }
        }

        binding.claimsButton.setOnClickListener {
            if (currentlySelected != "CLAIMS") {
                currentlySelected = "CLAIMS"
                updateView()
            }
        }

        return binding.root
    }

    private fun observerList(){
        viewModel.spaceListingLiveData.observe(viewLifecycleOwner) {
            it?.let {
                spaceListingList.clear()
                spaceListingList.addAll(it)
                binding.listingsListRecyclerview.adapter?.notifyDataSetChanged()
            }
        }

        viewModel.spaceClaimLiveData.observe(viewLifecycleOwner) {
            it?.let {
                spaceClaimList.clear()
                spaceClaimList.addAll(it)
                binding.claimsListRecyclerview.adapter?.notifyDataSetChanged()
            }
        }
    }

    private fun updateView() {
        binding.listingsButton.background = null
        binding.claimsButton.background = null
        binding.listingsButton.setTextColor(Color.parseColor("#3F3F3F"))
        binding.claimsButton.setTextColor(Color.parseColor("#3F3F3F"))
        binding.listingsListRecyclerview.visibility = View.GONE
        binding.claimsListRecyclerview.visibility = View.GONE

        when(currentlySelected) {
            "LISTINGS" -> {
                binding.listingsListRecyclerview.visibility = View.VISIBLE
                binding.listingsButton.background = ContextCompat.getDrawable(requireContext(), R.drawable.host_bg_end_rounded)
                binding.listingsButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.themeColor))
            }
            "CLAIMS" -> {
                binding.claimsListRecyclerview.visibility = View.VISIBLE
                binding.claimsButton.background = ContextCompat.getDrawable(requireContext(), R.drawable.host_bg_start_rounded)
                binding.claimsButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.themeColor))
            }
        }
    }
}





class HostSpaceViewModelFactory(private val repository: HostSpaceRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = HostSpaceViewModel(repository) as T
}