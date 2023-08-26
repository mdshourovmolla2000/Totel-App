package com.shourov.totel.view.host_activity.profile_screen

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.shourov.totel.R
import com.shourov.totel.databinding.BottomSheetSignOutBinding
import com.shourov.totel.databinding.FragmentHostProfileBinding
import com.shourov.totel.utils.SharedPref
import com.shourov.totel.utils.showSuccessToast
import com.shourov.totel.view.welcome_screen.WelcomeActivity

class HostProfileFragment : Fragment() {

    private lateinit var binding: FragmentHostProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHostProfileBinding.inflate(inflater, container, false)

        binding.switchButton.setOnClickListener {
            SharedPref.write("USER_MODE", "guest")
            val intent = Intent(requireActivity(), WelcomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.enter, R.anim.exit)
        }

        binding.accountButton.setOnClickListener {
            if (binding.accountSubSectionLayout.visibility == View.GONE) {
                binding.accountSubSectionLayout.visibility = View.VISIBLE
                binding.accountArrowIcon.setImageResource(R.drawable.host_profile_arrow_up_icon)
                binding.accountTextview.setTextColor(ContextCompat.getColor(requireContext(), R.color.themeColor))
                binding.accountIcon.setColorFilter(ContextCompat.getColor(requireContext(), R.color.themeColor))
            } else {
                binding.accountSubSectionLayout.visibility = View.GONE
                binding.accountArrowIcon.setImageResource(R.drawable.host_profile_arrow_down_icon)
                binding.accountTextview.setTextColor(Color.parseColor("#3F3F3F"))
                binding.accountIcon.clearColorFilter()
            }
        }

        binding.logoutButton.setOnClickListener { signOutDialog() }

        return binding.root
    }

    private fun signOutDialog() {
        val bottomSheet = BottomSheetDialog(requireContext())
        val bottomSheetBinding = BottomSheetSignOutBinding.bind(LayoutInflater.from(requireContext()).inflate(
            R.layout.bottom_sheet_sign_out, null))

        bottomSheet.setContentView(bottomSheetBinding.root)

        bottomSheetBinding.closeButton.setOnClickListener { bottomSheet.dismiss() }

        bottomSheetBinding.yesButton.setOnClickListener {
            bottomSheet.dismiss()
            requireContext().showSuccessToast("Signed Out")
            SharedPref.write("IS_SIGNED_IN", "no")
            SharedPref.write("USER_MODE", "guest")
            val intent = Intent(requireActivity(), WelcomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.enter, R.anim.exit)
        }

        bottomSheetBinding.cancelButton.setOnClickListener { bottomSheet.dismiss() }

        bottomSheet.show()
    }
}