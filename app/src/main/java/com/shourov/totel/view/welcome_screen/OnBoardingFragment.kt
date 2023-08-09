package com.shourov.totel.view.welcome_screen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shourov.totel.R
import com.shourov.totel.adapter.OnBoardingViewPagerAdapter
import com.shourov.totel.databinding.FragmentOnBoardingBinding
import com.shourov.totel.model.OnBoardingModel
import com.shourov.totel.repository.OnBoardingRepository
import com.shourov.totel.view.auth_screen.AuthActivity
import com.shourov.totel.view_model.OnBoardingViewModel

class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding

    private val onBoardingData: ArrayList<OnBoardingModel> = ArrayList()
    private var onBoardingViewPagerAdapter: OnBoardingViewPagerAdapter? = null
    private var position = 0

    private lateinit var viewModel: OnBoardingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, OnBoardingViewModelFactory(OnBoardingRepository()))[OnBoardingViewModel::class.java]

        viewModel.getOnBoardingData()

        observerList()

        onBoardingViewPagerAdapter = OnBoardingViewPagerAdapter(onBoardingData)
        binding.screenPager.adapter = onBoardingViewPagerAdapter
        binding.tabIndicator.setupWithViewPager(binding.screenPager)

        binding.createAccountButton.setOnClickListener {
            goToNextScreen("CREATE_ACCOUNT")
        }

        binding.signInButton.setOnClickListener {
            goToNextScreen("SIGN_IN")
        }

        return binding.root
    }

    private fun observerList() {
        viewModel.onBoardingLiveData.observe(viewLifecycleOwner){
            onBoardingData.clear()
            onBoardingData.addAll(it)
            binding.screenPager.adapter?.notifyDataSetChanged()
        }
    }

    private fun goToNextScreen(screen: String) {
        val intent = Intent(requireActivity(), AuthActivity::class.java)
        intent.putExtra("WHERE_TO_GO", screen)
        startActivity(intent)
        requireActivity().overridePendingTransition(R.anim.enter, R.anim.exit)
    }
}




class OnBoardingViewModelFactory(private val repository: OnBoardingRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = OnBoardingViewModel(repository) as T
}