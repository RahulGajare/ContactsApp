package com.rg.contacts.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rg.contacts.fragments.ContactsFragment
import com.rg.contacts.fragments.FavContactsFragment

class HomePageFragmentAdapter(fragmentActivity : FragmentActivity) : FragmentStateAdapter(fragmentActivity)
{
    override fun getItemCount(): Int {
        return 2;
    }

    override fun createFragment(position: Int): Fragment {
        when (position)
        {
            1 -> {
                    return  ContactsFragment();
            }
                2 ->
                {
                    return  FavContactsFragment();
                }
        }

        return  ContactsFragment();
    }
}