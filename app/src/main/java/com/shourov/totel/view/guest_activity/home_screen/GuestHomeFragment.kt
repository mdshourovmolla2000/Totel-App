package com.shourov.totel.view.guest_activity.home_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shourov.totel.adapter.GuestHomeAlreadyBookedListAdapter
import com.shourov.totel.databinding.FragmentGuestHomeBinding
import com.shourov.totel.model.HomeAlreadyBookedModel
import com.shourov.totel.repository.GuestHomeRepository
import com.shourov.totel.view_model.GuestHomeViewModel

class GuestHomeFragment : Fragment() {

    private lateinit var binding: FragmentGuestHomeBinding

    private lateinit var viewModel: GuestHomeViewModel

    private val homeAlreadyBookedList = ArrayList<HomeAlreadyBookedModel?>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGuestHomeBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, GuestHomeViewModelFactory(GuestHomeRepository()))[GuestHomeViewModel::class.java]

        viewModel.getHomeAlreadyBooked()

        observerList()

        binding.homeAlreadyBookedRecyclerview.adapter = GuestHomeAlreadyBookedListAdapter(homeAlreadyBookedList)

        return binding.root
    }

    private fun observerList(){
        viewModel.homeAlreadyBookedLiveData.observe(viewLifecycleOwner) {
            homeAlreadyBookedList.clear()
            homeAlreadyBookedList.addAll(ArrayList(it))
            binding.homeAlreadyBookedRecyclerview.adapter?.notifyDataSetChanged()
        }
    }
}




class GuestHomeViewModelFactory(private val repository: GuestHomeRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = GuestHomeViewModel(repository) as T
}