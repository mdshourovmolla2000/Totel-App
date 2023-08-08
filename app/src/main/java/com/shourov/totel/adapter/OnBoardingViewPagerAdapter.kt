package com.shourov.totel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.shourov.totel.databinding.SingleOnboardingScreenItemLayoutBinding
import com.shourov.totel.model.OnBoardingModel
import com.shourov.totel.utils.loadImage

class OnBoardingViewPagerAdapter(private val itemList: List<OnBoardingModel>): PagerAdapter() {
    override fun getCount(): Int {
        return itemList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = SingleOnboardingScreenItemLayoutBinding.inflate(LayoutInflater.from(container.context), container, false)

        binding.itemImageview.loadImage(itemList[position].imageUrl)
        binding.titleTextview.text = itemList[position].title
        binding.descriptionTextview.text = itemList[position].description

        container.addView(binding.root)

        return binding.root
    }
}