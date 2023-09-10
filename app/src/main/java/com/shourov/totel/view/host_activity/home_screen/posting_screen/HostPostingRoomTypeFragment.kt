package com.shourov.totel.view.host_activity.home_screen.posting_screen

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentHostPostingRoomTypeBinding

class HostPostingRoomTypeFragment : Fragment() {

    private lateinit var binding: FragmentHostPostingRoomTypeBinding

    private var currentlySelected = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHostPostingRoomTypeBinding.inflate(inflater, container, false)

        updateView()

        binding.entireHouseButton.setOnClickListener {
            if (currentlySelected != "ENTIRE_HOUSE") {
                currentlySelected = "ENTIRE_HOUSE"
                updateView()
            }
        }

        binding.sharedRoomButton.setOnClickListener {
            if (currentlySelected != "SHARED_ROOM") {
                currentlySelected = "SHARED_ROOM"
                updateView()
            }
        }

        binding.singleRoomButton.setOnClickListener {
            if (currentlySelected != "SINGLE_ROOM") {
                currentlySelected = "SINGLE_ROOM"
                updateView()
            }
        }

        binding.backButton.setOnClickListener { findNavController().popBackStack() }

        binding.continueButton.setOnClickListener { findNavController().navigate(R.id.action_hostPostingRoomTypeFragment_to_hostPostingPlaceLocationFragment) }

        return binding.root
    }

    private fun updateView() {
        binding.entireHouseButtonBg.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_with_white_bg)
        binding.sharedRoomButtonBg.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_with_white_bg)
        binding.singleRoomButtonBg.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_with_white_bg)
        binding.entireHouseIcon.clearColorFilter()
        binding.sharedRoomIcon.clearColorFilter()
        binding.singleRoomIcon.clearColorFilter()
        binding.entireHouseTextview.setTextColor(Color.parseColor("#272D37"))
        binding.sharedRoomTextview.setTextColor(Color.parseColor("#272D37"))
        binding.singleRoomTextview.setTextColor(Color.parseColor("#272D37"))

        when(currentlySelected) {
            "ENTIRE_HOUSE" -> {
                binding.entireHouseButtonBg.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.themeColor))
                binding.entireHouseIcon.setColorFilter(Color.parseColor("#FFFFFF"))
                binding.entireHouseTextview.setTextColor(Color.parseColor("#FFFFFF"))
            }
            "SHARED_ROOM" -> {
                binding.sharedRoomButtonBg.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.themeColor))
                binding.sharedRoomIcon.setColorFilter(Color.parseColor("#FFFFFF"))
                binding.sharedRoomTextview.setTextColor(Color.parseColor("#FFFFFF"))
            }
            "SINGLE_ROOM" -> {
                binding.singleRoomButtonBg.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.themeColor))
                binding.singleRoomIcon.setColorFilter(Color.parseColor("#FFFFFF"))
                binding.singleRoomTextview.setTextColor(Color.parseColor("#FFFFFF"))
            }
        }
    }
}