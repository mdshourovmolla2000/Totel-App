package com.shourov.totel.view.auth_screen.create_account_screen

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.adapter.HobbyListAdapter
import com.shourov.totel.databinding.FragmentCreateAccountHobbiesBinding
import com.shourov.totel.interfaces.HobbyItemClickListener
import com.shourov.totel.model.HobbyModel
import com.shourov.totel.repository.CreateAccountHobbiesRepository
import com.shourov.totel.utils.showInfoToast
import com.shourov.totel.utils.showSuccessToast
import com.shourov.totel.view.MainActivity
import com.shourov.totel.view_model.CreateAccountHobbiesViewModel

class CreateAccountHobbiesFragment : Fragment(), HobbyItemClickListener {

    private lateinit var binding: FragmentCreateAccountHobbiesBinding

    private lateinit var repository: CreateAccountHobbiesRepository
    private lateinit var viewModel: CreateAccountHobbiesViewModel

    private val hobbiesList = ArrayList<HobbyModel>()

    private var selectedHobbiesCount = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateAccountHobbiesBinding.inflate(inflater, container, false)

        selectedHobbiesCount = 0

        repository = CreateAccountHobbiesRepository()
        viewModel = ViewModelProvider(this, CreateAccountHobbiesViewModelFactory(repository))[CreateAccountHobbiesViewModel::class.java]

        viewModel.getHobbies()

        observerList()

        binding.hobbiesRecyclerview.adapter = HobbyListAdapter(hobbiesList, this)

        binding.continueButton.setOnClickListener {
            requireContext().showSuccessToast("Account created")
            val intent = Intent(requireActivity(), MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.enter, R.anim.exit)
        }

        binding.skipButton.setOnClickListener {
            requireContext().showSuccessToast("Account created")
            val intent = Intent(requireActivity(), MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.enter, R.anim.exit)
        }

        return binding.root
    }

    private fun observerList() {
        viewModel.hobbiesLiveData.observe(viewLifecycleOwner) {
            hobbiesList.clear()
            hobbiesList.addAll(it)
            binding.hobbiesRecyclerview.adapter?.notifyDataSetChanged()
        }
    }

    override fun onItemClick(currentItem: HobbyModel) {
        if (currentItem.isSelected) {
            currentItem.isSelected = false
            selectedHobbiesCount--
        } else {
            if (selectedHobbiesCount >= 5) {
                requireContext().showInfoToast("Max 5 items")
            } else {
                currentItem.isSelected = true
                selectedHobbiesCount++
            }
        }

        binding.hobbiesRecyclerview.adapter?.notifyDataSetChanged()
    }
}




class CreateAccountHobbiesViewModelFactory(private val repository: CreateAccountHobbiesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = CreateAccountHobbiesViewModel(repository) as T
}