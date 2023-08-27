package com.shourov.totel.view.host_activity.profile_screen.account_sub_section.bookings_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shourov.totel.adapter.HostBookingsListAdapter
import com.shourov.totel.databinding.FragmentHostBookingsBinding
import com.shourov.totel.model.BookingModel
import com.shourov.totel.repository.HostBookingsRepository
import com.shourov.totel.view_model.HostBookingsViewModel

class HostBookingsFragment : Fragment() {

    private lateinit var binding: FragmentHostBookingsBinding

    private lateinit var viewModel: HostBookingsViewModel

    private val bookingsBookedList = ArrayList<BookingModel?>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHostBookingsBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, HostBookingsViewModelFactory(HostBookingsRepository()))[HostBookingsViewModel::class.java]

        viewModel.getBookingsBookedList()

        observerList()

        binding.backIcon.setOnClickListener { findNavController().popBackStack() }

        binding.bookingsListRecyclerview.adapter = HostBookingsListAdapter(bookingsBookedList)

        return binding.root
    }

    private fun observerList(){
        viewModel.bookingsBookedListLiveData.observe(viewLifecycleOwner) {
            it?.let {
                bookingsBookedList.clear()
                bookingsBookedList.addAll(it)
                binding.bookingsListRecyclerview.adapter?.notifyDataSetChanged()
            }
        }
    }
}




class HostBookingsViewModelFactory(private val repository: HostBookingsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = HostBookingsViewModel(repository) as T
}