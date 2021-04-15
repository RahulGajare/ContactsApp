package com.rg.contacts.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import com.rg.contacts.R
import com.rg.contacts.adapters.HomePageFragmentAdapter
import com.rg.contacts.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private val titles = arrayOf("All Contacts", "Favourites")
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_home)

        // The pager adapter, which provides the pages to the view pager widget.
        val adapter = HomePageFragmentAdapter(this)
        binding.ViewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.ViewPager,
                TabConfigurationStrategy { tab, position -> tab.setText(titles.get(position)) }).attach()

    }


}