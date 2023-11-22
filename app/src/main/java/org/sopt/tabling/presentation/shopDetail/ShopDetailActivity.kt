package org.sopt.tabling.presentation.shopDetail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.tabling.R
import org.sopt.tabling.databinding.ActivityShopDetailBinding
import org.sopt.tabling.presentation.common.ViewModelFactory
import org.sopt.tabling.util.binding.BindingActivity
import org.sopt.tabling.util.extension.setRatingBar

class ShopDetailActivity :
    BindingActivity<ActivityShopDetailBinding>(R.layout.activity_shop_detail) {
    private val shopDetailViewModel: ShopDetailViewModel by viewModels { ViewModelFactory() }
    private lateinit var shopDetailShopImgAdapter: ShopDetailShopImgAdapter
    private lateinit var shopDetailTabAdapter: ShopDetailTabAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.shopDetailViewModel = shopDetailViewModel

        initLayout()
    }

    private fun initLayout() {
        initShopImgViewPager()
        initTabLayout()

        with(binding) {
            shopDetailViewModel?.let { shopDetailViewModel ->
                chipShopDetailWaiting.text = getString(
                    R.string.shop_detail_waiting,
                    shopDetailViewModel.mockShopDetailInfo.currentWaiting
                )
                tvShopDetailShopInfoName.text = shopDetailViewModel.mockShopDetailInfo.name
                tvShopDetailShopInfoAddress.text =
                    shopDetailViewModel.mockShopDetailInfo.longAddress
                tvShopDetailInfoStar.text =
                    shopDetailViewModel.mockShopDetailInfo.averageStar.toString()
                includeShopDetailInfoStar.setRatingBar(shopDetailViewModel.mockShopDetailInfo.averageStar)
                tvShopDetailInfoReviewCount.text = getString(
                    R.string.shop_detail_review_count,
                    shopDetailViewModel.mockShopDetailInfo.reviewCount
                )
            }
        }
    }

    private fun initShopImgViewPager() {
        shopDetailShopImgAdapter = ShopDetailShopImgAdapter()
        binding.vpShopDetailShopImg.adapter = shopDetailShopImgAdapter
        shopDetailShopImgAdapter.submitList(shopDetailViewModel.mockShopDetailInfo.detailPhotoList)
        setTvShopDetailShopImgPageText(FIST_POSITION)

        binding.vpShopDetailShopImg.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setTvShopDetailShopImgPageText(position)
            }
        })
    }

    private fun initTabLayout() {
        shopDetailTabAdapter = ShopDetailTabAdapter(this@ShopDetailActivity)
        binding.vpShopDetailTab.adapter = shopDetailTabAdapter

        TabLayoutMediator(
            binding.tlShopDetail,
            binding.vpShopDetailTab
        ) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.shop_detail_tab_layout_home)
                1 -> getString(R.string.shop_detail_tab_layout_menu_list)
                else -> getString(R.string.shop_detail_tab_layout_recent_review)
            }
        }.attach()
    }

    private fun setTvShopDetailShopImgPageText(currentPage: Int) {
        binding.tvShopDetailShopImgPage.text = getString(
            R.string.shop_detail_shop_img_page,
            currentPage + 1,
            shopDetailShopImgAdapter.currentList.size
        )
    }

    companion object {
        const val FIST_POSITION = 0
    }
}
