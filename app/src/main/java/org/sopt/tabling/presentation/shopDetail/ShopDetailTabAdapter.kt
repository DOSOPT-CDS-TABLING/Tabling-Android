package org.sopt.tabling.presentation.shopDetail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.sopt.tabling.presentation.shopDetailHome.ShopDetailHomeFragment
import org.sopt.tabling.presentation.shopDetailMenuList.ShopDetailMenuListFragment
import org.sopt.tabling.presentation.shopDetailRecentReview.ShopDetailRecentReviewFragment

class ShopDetailTabAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = TAB_ITEM_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ShopDetailHomeFragment()
            1 -> ShopDetailMenuListFragment()
            else -> ShopDetailRecentReviewFragment()
        }
    }

    companion object {
        private const val TAB_ITEM_COUNT = 3
    }
}
