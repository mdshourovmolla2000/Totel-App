package com.shourov.totel.view.home_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shourov.totel.adapter.HomeAlreadyBookedListAdapter
import com.shourov.totel.databinding.FragmentHomeBinding
import com.shourov.totel.model.HomeAlreadyBookedModel
import com.shourov.totel.repository.HomeRepository
import com.shourov.totel.view_model.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var viewModel: HomeViewModel

    private val homeAlreadyBookedList = ArrayList<HomeAlreadyBookedModel?>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, HomeViewModelFactory(HomeRepository()))[HomeViewModel::class.java]

        viewModel.getHomeAlreadyBooked()

        observerList()

        binding.homeAlreadyBookedRecyclerview.adapter = HomeAlreadyBookedListAdapter(homeAlreadyBookedList)

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




class HomeViewModelFactory(private val repository: HomeRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = HomeViewModel(repository) as T
}