package com.naat.yaapp.presentation.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.naat.yaapp.presentation.fragments.RechargeFragment

private val TAB_TITLES = arrayOf(
    "RECARGAS",
    "RECAUDACIÓN",
    "ADMINISTRACIÓN"
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return RechargeFragment.newInstance()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TAB_TITLES[position]
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }
}