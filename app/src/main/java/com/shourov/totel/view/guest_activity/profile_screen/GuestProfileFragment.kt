package com.shourov.totel.view.guest_activity.profile_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.adapter.GuestProfileAlreadyBookedListAdapter
import com.shourov.totel.databinding.FragmentGuestProfileBinding
import com.shourov.totel.model.ProfileAlreadyBookedModel
import com.shourov.totel.repository.GuestProfileRepository
import com.shourov.totel.view_model.GuestProfileViewModel

class GuestProfileFragment : Fragment() {

    private lateinit var binding: FragmentGuestProfileBinding

    private lateinit var viewModel: GuestProfileViewModel

    private val profileAlreadyBookedList = ArrayList<ProfileAlreadyBookedModel?>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGuestProfileBinding.inflate(inflater, container, false)

        binding.showMoreButton.setOnClickListener {
            binding.showMoreButton.visibility = View.GONE
            binding.hiddenDetailsLayout.visibility = View.VISIBLE
        }

        viewModel = ViewModelProvider(this, GuestProfileViewModelFactory(GuestProfileRepository()))[GuestProfileViewModel::class.java]

        viewModel.getProfileAlreadyBooked()

        observerList()

        binding.settingIcon.setOnClickListener { findNavController().navigate(R.id.action_guestProfileFragment_to_settingsFragment) }

        binding.profileAlreadyBookedRecyclerview.adapter = GuestProfileAlreadyBookedListAdapter(profileAlreadyBookedList)

        return binding.root
    }

    private fun observerList(){
        viewModel.profileAlreadyBookedLiveData.observe(viewLifecycleOwner) {
            profileAlreadyBookedList.clear()
            profileAlreadyBookedList.addAll(ArrayList(it))
            binding.profileAlreadyBookedRecyclerview.adapter?.notifyDataSetChanged()
        }
    }
}




class GuestProfileViewModelFactory(private val repository: GuestProfileRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = GuestProfileViewModel(repository) as T
}