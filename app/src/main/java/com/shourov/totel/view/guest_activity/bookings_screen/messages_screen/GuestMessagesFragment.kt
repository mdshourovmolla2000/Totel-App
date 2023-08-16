package com.shourov.totel.view.guest_activity.bookings_screen.messages_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.adapter.GuestMessageListAdapter
import com.shourov.totel.databinding.FragmentGuestMessagesBinding
import com.shourov.totel.interfaces.GuestMessageItemClickListener
import com.shourov.totel.model.MessageModel
import com.shourov.totel.repository.GuestMessagesRepository
import com.shourov.totel.view_model.GuestMessagesViewModel

class GuestMessagesFragment : Fragment(), GuestMessageItemClickListener {

    private lateinit var binding: FragmentGuestMessagesBinding

    private lateinit var viewModel: GuestMessagesViewModel

    private val messageList = ArrayList<MessageModel?>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGuestMessagesBinding.inflate(inflater, container, false)

        binding.bookingsIcon.setOnClickListener { findNavController().popBackStack() }

        viewModel = ViewModelProvider(this, GuestMessageViewModelFactory(GuestMessagesRepository()))[GuestMessagesViewModel::class.java]

        viewModel.getMessages()

        observerList()

        binding.messageRecyclerview.adapter = GuestMessageListAdapter(messageList, this)

        return binding.root
    }

    private fun observerList(){
        viewModel.messageLiveData.observe(viewLifecycleOwner) {
            messageList.clear()
            messageList.addAll(it)
            binding.messageRecyclerview.adapter?.notifyDataSetChanged()
        }
    }

    override fun onItemClick(currentItem: MessageModel) {
        val bundle = bundleOf(
            "DATA" to currentItem.userName
        )
        findNavController().navigate(R.id.action_guestMessagesFragment_to_guestChatFragment, bundle)
    }
}




class GuestMessageViewModelFactory(private val repository: GuestMessagesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = GuestMessagesViewModel(repository) as T
}