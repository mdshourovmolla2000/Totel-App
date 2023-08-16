package com.shourov.totel.view.guest_activity.notification_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shourov.totel.adapter.GuestNotificationListAdapter
import com.shourov.totel.databinding.FragmentGuestNotificationBinding
import com.shourov.totel.model.NotificationModel
import com.shourov.totel.repository.GuestNotificationRepository
import com.shourov.totel.view_model.GuestNotificationViewModel

class GuestNotificationFragment : Fragment() {

    private lateinit var binding: FragmentGuestNotificationBinding

    private lateinit var viewModel: GuestNotificationViewModel

    private val todayNotificationList = ArrayList<NotificationModel?>()
    private val thisWeekNotificationList = ArrayList<NotificationModel?>()
    private val thisMonthNotificationList = ArrayList<NotificationModel?>()
    private val earlierNotificationList = ArrayList<NotificationModel?>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGuestNotificationBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, GuestNotificationViewModelFactory(GuestNotificationRepository()))[GuestNotificationViewModel::class.java]

        viewModel.getNotification()

        observerList()

        binding.notificationTodayRecyclerview.adapter = GuestNotificationListAdapter(todayNotificationList)
        binding.notificationThisWeekRecyclerview.adapter = GuestNotificationListAdapter(thisWeekNotificationList)
        binding.notificationThisMonthRecyclerview.adapter = GuestNotificationListAdapter(thisMonthNotificationList)
        binding.notificationEarlierRecyclerview.adapter = GuestNotificationListAdapter(earlierNotificationList)

        return binding.root
    }

    private fun observerList(){
        viewModel.notificationLiveData.observe(viewLifecycleOwner) {

            todayNotificationList.clear()
            thisWeekNotificationList.clear()
            thisMonthNotificationList.clear()
            earlierNotificationList.clear()

            todayNotificationList.addAll(ArrayList(it.filter { item -> item?.notificationCategory == "Today" }))
            binding.notificationTodayRecyclerview.adapter?.notifyDataSetChanged()

            thisWeekNotificationList.addAll(ArrayList(it.filter { item -> item?.notificationCategory == "This Week" }))
            binding.notificationThisWeekRecyclerview.adapter?.notifyDataSetChanged()

            thisMonthNotificationList.addAll(ArrayList(it.filter { item -> item?.notificationCategory == "This Month" }))
            binding.notificationThisMonthRecyclerview.adapter?.notifyDataSetChanged()

            earlierNotificationList.addAll(ArrayList(it.filter { item -> item?.notificationCategory == "Earlier" }))
            binding.notificationEarlierRecyclerview.adapter?.notifyDataSetChanged()
        }
    }
}




class GuestNotificationViewModelFactory(private val repository: GuestNotificationRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = GuestNotificationViewModel(repository) as T
}