package org.sopt.tabling.presentation.shopDetailRecentReview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import org.sopt.tabling.R
import org.sopt.tabling.databinding.FragmentShopDetailRecentReviewBinding
import org.sopt.tabling.presentation.common.ViewModelFactory
import org.sopt.tabling.presentation.shopDetail.ShopDetailViewModel
import org.sopt.tabling.util.binding.BindingFragment
import org.sopt.tabling.util.extension.setRatingBar

class ShopDetailRecentReviewFragment :
    BindingFragment<FragmentShopDetailRecentReviewBinding>(R.layout.fragment_shop_detail_recent_review) {
    private val shopDetailViewModel: ShopDetailViewModel by viewModels { ViewModelFactory() }
    private lateinit var shopDetailRecentReviewAdapter: ShopDetailRecentReviewAdapter
    private val convertDetailStarValue: (Float) -> Int = { value -> (value * 20).toInt() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shopDetailViewModel = shopDetailViewModel

        initLayout()
    }

    private fun initLayout() {
        with(binding) {
            shopDetailViewModel?.let { shopDetailViewModel ->
                tvShopDetailRecentReviewTitle.text = getString(
                    R.string.shop_detail_recent_review_title,
                    shopDetailViewModel.mockShopDetailInfo.reviewCount
                )
                tvShopDetailRecentReviewTotalStarContext.text =
                    shopDetailViewModel.mockShopDetailInfo.averageStar.toString()
                includeShopDetailRecentReviewTotalStar.setRatingBar(shopDetailViewModel.mockShopDetailInfo.averageStar)
                includeShopDetailRecentReviewDetailStarFoodTaste.tvProgressBarTitle.text =
                    getString(R.string.shop_detail_recent_review_food_taste)
                includeShopDetailRecentReviewDetailStarFoodTaste.pbProgressBar.progress =
                    convertDetailStarValue(shopDetailViewModel.mockShopDetailInfo.detailStarList[FOOD_TASTE])
                includeShopDetailRecentReviewDetailStarFoodTaste.tvProgressBarScore.text =
                    getString(
                        R.string.shop_detail_recent_review_score,
                        shopDetailViewModel.mockShopDetailInfo.detailStarList[FOOD_TASTE]
                    )
                includeShopDetailRecentReviewDetailStarMood.tvProgressBarTitle.text =
                    getString(R.string.shop_detail_recent_review_mood)
                includeShopDetailRecentReviewDetailStarMood.pbProgressBar.progress =
                    convertDetailStarValue(shopDetailViewModel.mockShopDetailInfo.detailStarList[MOOD])
                includeShopDetailRecentReviewDetailStarMood.tvProgressBarScore.text =
                    getString(
                        R.string.shop_detail_recent_review_score,
                        shopDetailViewModel.mockShopDetailInfo.detailStarList[MOOD]
                    )
                includeShopDetailRecentReviewDetailStarKindness.tvProgressBarTitle.text =
                    getString(R.string.shop_detail_recent_review_kindness)
                includeShopDetailRecentReviewDetailStarKindness.pbProgressBar.progress =
                    convertDetailStarValue(shopDetailViewModel.mockShopDetailInfo.detailStarList[KINDNESS])
                includeShopDetailRecentReviewDetailStarKindness.tvProgressBarScore.text =
                    getString(
                        R.string.shop_detail_recent_review_score,
                        shopDetailViewModel.mockShopDetailInfo.detailStarList[KINDNESS]
                    )
                includeShopDetailRecentReviewDetailStarCleanliness.tvProgressBarTitle.text =
                    getString(R.string.shop_detail_recent_review_cleanliness)
                includeShopDetailRecentReviewDetailStarCleanliness.pbProgressBar.progress =
                    convertDetailStarValue(shopDetailViewModel.mockShopDetailInfo.detailStarList[CLEANLINESS])
                includeShopDetailRecentReviewDetailStarCleanliness.tvProgressBarScore.text =
                    getString(
                        R.string.shop_detail_recent_review_score,
                        shopDetailViewModel.mockShopDetailInfo.detailStarList[CLEANLINESS]
                    )
                shopDetailRecentReviewAdapter = ShopDetailRecentReviewAdapter()
                rvShopDetailRecentReview.adapter = shopDetailRecentReviewAdapter
                shopDetailRecentReviewAdapter.submitList(shopDetailViewModel.mockShopDetailInfo.reviewList)
                includeShopDetailRecentReviewDetailBtn.tvDetailBtn.text =
                    getString(R.string.shop_detail_recent_review_full_review_detail)
            }
        }
    }

    companion object {
        const val FOOD_TASTE = 0
        const val MOOD = 1
        const val KINDNESS = 2
        const val CLEANLINESS = 3
    }
}
