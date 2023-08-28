package com.shourov.totel.view.host_activity.profile_screen.account_sub_section.bookings_screen

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
import com.shourov.totel.adapter.HostBookingsListAdapter
import com.shourov.totel.databinding.FragmentHostBookingsBinding
import com.shourov.totel.model.BookingModel
import com.shourov.totel.repository.HostBookingsRepository
import com.shourov.totel.view_model.HostBookingsViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class HostBookingsFragment : Fragment() {

    private lateinit var binding: FragmentHostBookingsBinding

    private lateinit var viewModel: HostBookingsViewModel

    private val bookingsBookedList = ArrayList<BookingModel?>()
    private val bookingsHistoryList = ArrayList<BookingModel?>()

    private var currentlySelected = "BOOKED"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHostBookingsBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, HostBookingsViewModelFactory(HostBookingsRepository()))[HostBookingsViewModel::class.java]

        viewModel.getBookingsBookedList()

        observerList()

        updateView()

        binding.backIcon.setOnClickListener { findNavController().popBackStack() }

        binding.bookingsBookedListRecyclerview.adapter = HostBookingsListAdapter(bookingsBookedList)
        binding.bookingsHistoryListRecyclerview.adapter = HostBookingsListAdapter(bookingsHistoryList)

        binding.bookedButton.setOnClickListener {
            if (currentlySelected != "BOOKED") {
                currentlySelected = "BOOKED"
                updateView()
            }
        }

        binding.historyButton.setOnClickListener {
            if (currentlySelected != "HISTORY") {
                currentlySelected = "HISTORY"
                updateView()
            }
        }

        binding.calendarButton.setOnClickListener {
            if (currentlySelected != "CALENDAR") {
                currentlySelected = "CALENDAR"
                updateView()
            }
        }

        binding.calenderView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)
            val format = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
            val date = format.format(calendar.time)
            binding.selectedDateTextview.text = date
        }

        return binding.root
    }

    private fun observerList(){
        viewModel.bookingsBookedListLiveData.observe(viewLifecycleOwner) {
            it?.let {
                bookingsBookedList.clear()
                bookingsBookedList.addAll(it)
                binding.bookingsBookedListRecyclerview.adapter?.notifyDataSetChanged()
            }
            viewModel.getBookingsHistoryList()
        }

        viewModel.bookingsHistoryListLiveData.observe(viewLifecycleOwner) {
            it?.let {
                bookingsHistoryList.clear()
                bookingsHistoryList.addAll(it)
                binding.bookingsHistoryListRecyclerview.adapter?.notifyDataSetChanged()
            }
        }
    }

    private fun updateView() {
        binding.bookedButton.background = null
        binding.historyButton.background = null
        binding.calendarButton.background = null
        binding.bookedButton.setTextColor(Color.parseColor("#3F3F3F"))
        binding.historyButton.setTextColor(Color.parseColor("#3F3F3F"))
        binding.calendarButton.setTextColor(Color.parseColor("#3F3F3F"))
        binding.bookingsBookedListRecyclerview.visibility = View.GONE
        binding.bookingsHistoryListRecyclerview.visibility = View.GONE
        binding.filterButton.visibility = View.VISIBLE
        binding.calenderSectionLayout.visibility = View.GONE

        when(currentlySelected) {
            "BOOKED" -> {
                binding.bookingsBookedListRecyclerview.visibility = View.VISIBLE
                binding.bookedButton.background = ContextCompat.getDrawable(requireContext(), R.drawable.host_bg_end_rounded)
                binding.bookedButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.themeColor))
            }
            "HISTORY" -> {
                binding.bookingsHistoryListRecyclerview.visibility = View.VISIBLE
                binding.historyButton.background = ContextCompat.getDrawable(requireContext(), R.drawable.host_bg_rounded)
                binding.historyButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.themeColor))
            }
            "CALENDAR" -> {
                binding.calendarButton.background = ContextCompat.getDrawable(requireContext(), R.drawable.host_bg_start_rounded)
                binding.calendarButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.themeColor))
                binding.filterButton.visibility = View.GONE
                binding.calenderSectionLayout.visibility = View.VISIBLE
            }
        }
    }
}




class HostBookingsViewModelFactory(private val repository: HostBookingsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = HostBookingsViewModel(repository) as T
}