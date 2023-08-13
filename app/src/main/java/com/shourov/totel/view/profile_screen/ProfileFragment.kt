package com.shourov.totel.view.profile_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.adapter.ProfileAlreadyBookedListAdapter
import com.shourov.totel.databinding.FragmentProfileBinding
import com.shourov.totel.model.ProfileAlreadyBookedModel
import com.shourov.totel.repository.ProfileRepository
import com.shourov.totel.view_model.ProfileViewModel

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private lateinit var viewModel: ProfileViewModel

    private val profileAlreadyBookedList = ArrayList<ProfileAlreadyBookedModel?>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.showMoreButton.setOnClickListener {
            binding.showMoreButton.visibility = View.GONE
            binding.hiddenDetailsLayout.visibility = View.VISIBLE
        }

        viewModel = ViewModelProvider(this, ProfileViewModelFactory(ProfileRepository()))[ProfileViewModel::class.java]

        viewModel.getProfileAlreadyBooked()

        observerList()

        binding.settingIcon.setOnClickListener { findNavController().navigate(R.id.action_profileFragment_to_settingsFragment) }

        binding.profileAlreadyBookedRecyclerview.adapter = ProfileAlreadyBookedListAdapter(profileAlreadyBookedList)

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




class ProfileViewModelFactory(private val repository: ProfileRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = ProfileViewModel(repository) as T
}