package com.shourov.totel.view.notification_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shourov.totel.adapter.NotificationListAdapter
import com.shourov.totel.databinding.FragmentNotificationBinding
import com.shourov.totel.model.NotificationModel
import com.shourov.totel.repository.NotificationRepository
import com.shourov.totel.view_model.NotificationViewModel

class NotificationFragment : Fragment() {

    private lateinit var binding: FragmentNotificationBinding

    private lateinit var viewModel: NotificationViewModel

    private val todayNotificationList = ArrayList<NotificationModel?>()
    private val thisWeekNotificationList = ArrayList<NotificationModel?>()
    private val thisMonthNotificationList = ArrayList<NotificationModel?>()
    private val earlierNotificationList = ArrayList<NotificationModel?>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, NotificationViewModelFactory(NotificationRepository()))[NotificationViewModel::class.java]

        viewModel.getNotification()

        observerList()

        binding.notificationTodayRecyclerview.adapter = NotificationListAdapter(todayNotificationList)
        binding.notificationThisWeekRecyclerview.adapter = NotificationListAdapter(thisWeekNotificationList)
        binding.notificationThisMonthRecyclerview.adapter = NotificationListAdapter(thisMonthNotificationList)
        binding.notificationEarlierRecyclerview.adapter = NotificationListAdapter(earlierNotificationList)

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




class NotificationViewModelFactory(private val repository: NotificationRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = NotificationViewModel(repository) as T
}