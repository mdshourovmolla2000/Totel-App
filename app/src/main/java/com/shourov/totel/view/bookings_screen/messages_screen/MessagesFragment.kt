package com.shourov.totel.view.bookings_screen.messages_screen

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
import com.shourov.totel.adapter.MessageListAdapter
import com.shourov.totel.databinding.FragmentMessagesBinding
import com.shourov.totel.interfaces.MessageItemClickListener
import com.shourov.totel.model.MessageModel
import com.shourov.totel.repository.MessagesRepository
import com.shourov.totel.view_model.MessagesViewModel

class MessagesFragment : Fragment(), MessageItemClickListener {

    private lateinit var binding: FragmentMessagesBinding

    private lateinit var viewModel: MessagesViewModel

    private val messageList = ArrayList<MessageModel?>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMessagesBinding.inflate(inflater, container, false)

        binding.bookingsIcon.setOnClickListener { findNavController().popBackStack() }

        viewModel = ViewModelProvider(this, MessageViewModelFactory(MessagesRepository()))[MessagesViewModel::class.java]

        viewModel.getMessages()

        observerList()

        binding.messageRecyclerview.adapter = MessageListAdapter(messageList, this)

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
        findNavController().navigate(R.id.action_messagesFragment_to_chatFragment, bundle)
    }
}




class MessageViewModelFactory(private val repository: MessagesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = MessagesViewModel(repository) as T
}