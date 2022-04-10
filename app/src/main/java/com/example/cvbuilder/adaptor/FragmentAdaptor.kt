package com.example.cvbuilder.adaptor

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cvbuilder.AboutFragment
import com.example.cvbuilder.ContactFragment
import com.example.cvbuilder.ExperianceFragment
import com.example.cvbuilder.HomeFragment

class FragmentAdaptor(fragmentManager: FragmentManager, lifeCycle: Lifecycle): FragmentStateAdapter(fragmentManager,lifeCycle) {
    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
       return  when(position){
            0 -> HomeFragment()
            1 -> AboutFragment()
            2 -> ExperianceFragment()
            3 -> ContactFragment()
            else -> Fragment()
        }
    }
}