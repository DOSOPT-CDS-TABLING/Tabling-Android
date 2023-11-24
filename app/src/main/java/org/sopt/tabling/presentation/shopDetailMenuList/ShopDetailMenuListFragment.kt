package org.sopt.tabling.presentation.shopDetailMenuList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import org.sopt.tabling.R
import org.sopt.tabling.databinding.FragmentShopDetailMenuListBinding
import org.sopt.tabling.presentation.common.ViewModelFactory
import org.sopt.tabling.presentation.shopDetail.ShopDetailViewModel
import org.sopt.tabling.util.binding.BindingFragment

class ShopDetailMenuListFragment :
    BindingFragment<FragmentShopDetailMenuListBinding>(R.layout.fragment_shop_detail_menu_list) {
    private val shopDetailViewModel: ShopDetailViewModel by viewModels { ViewModelFactory() }
    private lateinit var shopDetailMenuListAdapter: ShopDetailMenuListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shopDetailViewModel = shopDetailViewModel

        initLayout()
    }

    private fun initLayout() {
        with(binding) {
            shopDetailViewModel?.let { shopDetailViewModel ->
                shopDetailMenuListAdapter = ShopDetailMenuListAdapter()
                binding.rvShopDetailMenuList.adapter = shopDetailMenuListAdapter
                shopDetailMenuListAdapter.submitList(shopDetailViewModel.mockShopDetailInfo.menuList)
                includeShopDetailMenuListDetailBtn.tvDetailBtn.text =
                    getString(R.string.shop_detail_menu_list_full_menu_detail)
            }
        }
    }
}
