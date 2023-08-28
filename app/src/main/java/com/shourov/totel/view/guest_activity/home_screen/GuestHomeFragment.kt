package com.shourov.totel.view.guest_activity.home_screen

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shourov.totel.adapter.GuestHomeAlreadyBookedListAdapter
import com.shourov.totel.adapter.GuestHomeLookingForPartnerListAdapter
import com.shourov.totel.databinding.FragmentGuestHomeBinding
import com.shourov.totel.model.HomeAlreadyBookedModel
import com.shourov.totel.model.HomeLookingForPartnerModel
import com.shourov.totel.repository.GuestHomeRepository
import com.shourov.totel.view_model.GuestHomeViewModel

class GuestHomeFragment : Fragment() {

    private lateinit var binding: FragmentGuestHomeBinding

    private lateinit var viewModel: GuestHomeViewModel

    private val homeAlreadyBookedList = ArrayList<HomeAlreadyBookedModel?>()
    private val homeLookingForPartnerList = ArrayList<HomeLookingForPartnerModel?>()

    private var currentlySelected = "ALREADY_BOOKED"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGuestHomeBinding.inflate(inflater, container, false)

        updateView()

        viewModel = ViewModelProvider(this, GuestHomeViewModelFactory(GuestHomeRepository()))[GuestHomeViewModel::class.java]

        viewModel.getHomeAlreadyBooked()

        observerList()

        binding.homeAlreadyBookedRecyclerview.adapter = GuestHomeAlreadyBookedListAdapter(homeAlreadyBookedList)
        binding.homeLookingForPartnerRecyclerview.adapter = GuestHomeLookingForPartnerListAdapter(homeLookingForPartnerList)

        binding.alreadyBookedButton.setOnClickListener {
            if (currentlySelected != "ALREADY_BOOKED") {
                currentlySelected = "ALREADY_BOOKED"
                updateView()
            }
        }

        binding.lookingForPartnerButton.setOnClickListener {
            if (currentlySelected != "LOOKING_FOR_PARTNER") {
                currentlySelected = "LOOKING_FOR_PARTNER"
                updateView()
            }
        }

        binding.rentedRoomsButton.setOnClickListener {
            if (currentlySelected != "RENTED_ROOMS") {
                currentlySelected = "RENTED_ROOMS"
                updateView()
            }
        }

        return binding.root
    }

    private fun observerList(){
        viewModel.homeAlreadyBookedLiveData.observe(viewLifecycleOwner) {
            homeAlreadyBookedList.clear()
            homeAlreadyBookedList.addAll(ArrayList(it))
            binding.homeAlreadyBookedRecyclerview.adapter?.notifyDataSetChanged()

            viewModel.getHomeLookingForPartner()
        }

        viewModel.homeLookingForPartnerLiveData.observe(viewLifecycleOwner) {
            homeLookingForPartnerList.clear()
            homeLookingForPartnerList.addAll(ArrayList(it))
            binding.homeLookingForPartnerRecyclerview.adapter?.notifyDataSetChanged()
        }
    }

    private fun updateView() {
        binding.alreadyBookedButton.background.setTint(Color.parseColor("#F2F2F7"))
        binding.lookingForPartnerButton.background.setTint(Color.parseColor("#F2F2F7"))
        binding.rentedRoomsButton.background.setTint(Color.parseColor("#F2F2F7"))
        binding.alreadyBookedButton.setTextColor(Color.parseColor("#000000"))
        binding.lookingForPartnerButton.setTextColor(Color.parseColor("#000000"))
        binding.rentedRoomsButton.setTextColor(Color.parseColor("#000000"))
        binding.homeAlreadyBookedRecyclerview.visibility = View.GONE
        binding.homeLookingForPartnerRecyclerview.visibility = View.GONE
        binding.homeRentedRoomsRecyclerview.visibility = View.GONE

        when(currentlySelected) {
            "ALREADY_BOOKED" -> {
                binding.alreadyBookedButton.background.setTint(Color.parseColor("#0057FF"))
                binding.alreadyBookedButton.setTextColor(Color.parseColor("#FFFFFF"))
                binding.homeAlreadyBookedRecyclerview.visibility = View.VISIBLE
            }
            "LOOKING_FOR_PARTNER" -> {
                binding.lookingForPartnerButton.background.setTint(Color.parseColor("#0057FF"))
                binding.lookingForPartnerButton.setTextColor(Color.parseColor("#FFFFFF"))
                binding.homeLookingForPartnerRecyclerview.visibility = View.VISIBLE
            }
            "RENTED_ROOMS" -> {
                binding.rentedRoomsButton.background.setTint(Color.parseColor("#0057FF"))
                binding.rentedRoomsButton.setTextColor(Color.parseColor("#FFFFFF"))
                binding.homeRentedRoomsRecyclerview.visibility = View.VISIBLE
            }
        }
    }
}




class GuestHomeViewModelFactory(private val repository: GuestHomeRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = GuestHomeViewModel(repository) as T
}