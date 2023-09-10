package com.shourov.totel.view.host_activity.profile_screen.account_sub_section.inbox_screen

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
import com.shourov.totel.adapter.GuestMessageListAdapter
import com.shourov.totel.adapter.GuestNotificationListAdapter
import com.shourov.totel.databinding.FragmentHostInboxBinding
import com.shourov.totel.interfaces.GuestMessageItemClickListener
import com.shourov.totel.model.MessageModel
import com.shourov.totel.model.NotificationModel
import com.shourov.totel.repository.HostInboxRepository
import com.shourov.totel.view_model.HostInboxViewModel

class HostInboxFragment : Fragment(), GuestMessageItemClickListener {

    private lateinit var binding: FragmentHostInboxBinding

    private lateinit var viewModel: HostInboxViewModel

    private val messageList = ArrayList<MessageModel?>()

    private val todayNotificationList = ArrayList<NotificationModel?>()
    private val thisWeekNotificationList = ArrayList<NotificationModel?>()
    private val thisMonthNotificationList = ArrayList<NotificationModel?>()
    private val earlierNotificationList = ArrayList<NotificationModel?>()

    private var currentlySelected = "MESSAGES"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHostInboxBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, HostInboxViewModelFactory(HostInboxRepository()))[HostInboxViewModel::class.java]

        viewModel.getMessages()
        viewModel.getNotification()

        observerList()

        updateView()

        binding.backIcon.setOnClickListener { findNavController().popBackStack() }

        binding.messageListRecyclerview.adapter = GuestMessageListAdapter(messageList, this)

        binding.notificationTodayRecyclerview.adapter = GuestNotificationListAdapter(todayNotificationList)
        binding.notificationThisWeekRecyclerview.adapter = GuestNotificationListAdapter(thisWeekNotificationList)
        binding.notificationThisMonthRecyclerview.adapter = GuestNotificationListAdapter(thisMonthNotificationList)
        binding.notificationEarlierRecyclerview.adapter = GuestNotificationListAdapter(earlierNotificationList)

        binding.messagesButton.setOnClickListener {
            if (currentlySelected != "MESSAGES") {
                currentlySelected = "MESSAGES"
                updateView()
            }
        }

        binding.notificationsButton.setOnClickListener {
            if (currentlySelected != "NOTIFICATIONS") {
                currentlySelected = "NOTIFICATIONS"
                updateView()
            }
        }

        return binding.root
    }

    private fun observerList(){
        viewModel.messageLiveData.observe(viewLifecycleOwner) {
            it?.let {
                messageList.clear()
                messageList.addAll(it)
                binding.messageListRecyclerview.adapter?.notifyDataSetChanged()
            }
        }

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

    private fun updateView() {
        binding.messagesButton.background = null
        binding.notificationsButton.background = null
        binding.messagesButton.setTextColor(Color.parseColor("#3F3F3F"))
        binding.notificationsButton.setTextColor(Color.parseColor("#3F3F3F"))
        binding.messageListRecyclerview.visibility = View.GONE
        binding.notificationSectionLayout.visibility = View.GONE

        when(currentlySelected) {
            "MESSAGES" -> {
                binding.messageListRecyclerview.visibility = View.VISIBLE
                binding.messagesButton.background = ContextCompat.getDrawable(requireContext(), R.drawable.host_bg_end_rounded)
                binding.messagesButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.themeColor))
            }
            "NOTIFICATIONS" -> {
                binding.notificationSectionLayout.visibility = View.VISIBLE
                binding.notificationsButton.background = ContextCompat.getDrawable(requireContext(), R.drawable.host_bg_start_rounded)
                binding.notificationsButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.themeColor))
            }
        }
    }

    override fun onItemClick(currentItem: MessageModel) {

    }
}




class HostInboxViewModelFactory(private val repository: HostInboxRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = HostInboxViewModel(repository) as T
}