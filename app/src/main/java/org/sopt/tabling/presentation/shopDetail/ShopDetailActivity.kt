package org.sopt.tabling.presentation.shopDetail

import android.animation.ArgbEvaluator
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.chip.Chip
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.sopt.tabling.R
import org.sopt.tabling.databinding.ActivityShopDetailBinding
import org.sopt.tabling.domain.model.ShopDetail
import org.sopt.tabling.presentation.Reserve.ReserveBottomSheetDialogFragment
import org.sopt.tabling.presentation.common.ViewModelFactory
import org.sopt.tabling.presentation.type.StarType
import org.sopt.tabling.util.UiState
import org.sopt.tabling.util.binding.BindingActivity
import org.sopt.tabling.util.extension.setData
import org.sopt.tabling.util.extension.setImageDrawableWithColorFilter
import org.sopt.tabling.util.extension.setRatingBar

class ShopDetailActivity :
    BindingActivity<ActivityShopDetailBinding>(R.layout.activity_shop_detail) {
    private val shopDetailViewModel: ShopDetailViewModel by viewModels { ViewModelFactory() }
    private lateinit var shopDetailShopImgAdapter: ShopDetailShopImgAdapter
    private lateinit var shopDetailMenuListAdapter: ShopDetailMenuListAdapter
    private lateinit var shopDetailRecentReviewAdapter: ShopDetailRecentReviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.shopDetailViewModel = shopDetailViewModel

        initLayout()
        addListeners()
        collectData()
    }

    override fun onDestroy() {
        super.onDestroy()

        with(binding) {
            vpShopDetailShopImg.adapter = null
            rvShopDetailMenuList.adapter = null
            rvShopDetailRecentReview.adapter = null
        }
    }

    private fun initLayout() {
        initAppBar()
        initTabLayout()
        initNestedScrollView()
    }

    private fun addListeners() {
        binding.btnShopDetailReserve.setOnClickListener {
            ReserveBottomSheetDialogFragment().show(supportFragmentManager, VISIT_PERSON)
        }
    }

    private fun collectData() {
        shopDetailViewModel.getShopDetailState.flowWithLifecycle(lifecycle).onEach { uiState ->
            when (uiState) {
                is UiState.Success -> {
                    uiState.data?.let { shopDetail ->
                        setShopImgViewPager(shopDetail)
                        setShopDetailAppBar(shopDetail)
                        setShopDetailHome(shopDetail)
                        setShopDetailMenuList(shopDetail)
                        setShopDetailRecentReview(shopDetail)
                    }
                }

                else -> Unit
            }
        }.launchIn(lifecycleScope)
    }

    private fun initAppBar() {
        with(binding) {
            ablShopDetail.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
                val maxScroll = appBarLayout.totalScrollRange
                val percentage = Math.abs(verticalOffset).toFloat() / maxScroll.toFloat()

                tbShopDetail.setBackgroundColor(
                    ArgbEvaluator().evaluate(
                        percentage,
                        Color.TRANSPARENT,
                        Color.WHITE
                    ) as Int
                )

                val iconEvaluator = ArgbEvaluator().evaluate(
                    percentage,
                    ContextCompat.getColor(this@ShopDetailActivity, R.color.white),
                    ContextCompat.getColor(this@ShopDetailActivity, R.color.gray_800)
                ) as Int

                ivShopDetailBack.setImageDrawableWithColorFilter(
                    this@ShopDetailActivity,
                    R.drawable.ic_back_white_45,
                    iconEvaluator
                )

                ivShopDetailHeart.setImageDrawableWithColorFilter(
                    this@ShopDetailActivity,
                    R.drawable.ic_heart_white_24,
                    iconEvaluator
                )

                ivShopDetailShare.setImageDrawableWithColorFilter(
                    this@ShopDetailActivity,
                    R.drawable.ic_share_white_24,
                    iconEvaluator
                )
            }
        }
    }

    private fun initTabLayout() {
        binding.tlShopDetail.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    HOME -> binding.nsvShopDetailContent.scrollTo(
                        Y_VALUE,
                        binding.layoutShopDetailHome.top
                    )

                    MENU_LIST -> binding.nsvShopDetailContent.scrollTo(
                        Y_VALUE,
                        binding.layoutShopDetailMenuList.top
                    )

                    RECENT_REVIEW -> binding.nsvShopDetailContent.scrollTo(
                        Y_VALUE,
                        binding.layoutShopDetailRecentReview.top
                    )
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) = Unit

            override fun onTabReselected(tab: TabLayout.Tab?) = Unit
        }
        )
    }

    private fun initNestedScrollView() {
        binding.nsvShopDetailContent.setOnScrollChangeListener(
            NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->
                when (scrollY) {
                    in binding.layoutShopDetailHome.top until binding.layoutShopDetailMenuList.top -> binding.tlShopDetail.setScrollPosition(
                        HOME,
                        FIRST_POSITION.toFloat(),
                        true
                    )

                    in binding.layoutShopDetailMenuList.top until binding.layoutShopDetailRecentReview.top -> binding.tlShopDetail.setScrollPosition(
                        MENU_LIST,
                        FIRST_POSITION.toFloat(),
                        true
                    )

                    in binding.layoutShopDetailRecentReview.top until binding.layoutShopDetailRecentReview.bottom -> binding.tlShopDetail.setScrollPosition(
                        RECENT_REVIEW,
                        FIRST_POSITION.toFloat(),
                        true
                    )
                }
            }
        )
    }

    private fun setShopImgViewPager(shopDetail: ShopDetail) {
        shopDetailShopImgAdapter = ShopDetailShopImgAdapter()
        binding.vpShopDetailShopImg.adapter = shopDetailShopImgAdapter
        shopDetailShopImgAdapter.submitList(shopDetail.detailPhotoList)
        setTvShopDetailShopImgPageText(FIRST_POSITION)

        binding.vpShopDetailShopImg.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setTvShopDetailShopImgPageText(position)
            }
        }
        )
    }

    private fun setShopDetailAppBar(shopDetail: ShopDetail) {
        with(binding) {
            chipShopDetailWaiting.text = getString(
                R.string.shop_detail_waiting,
                shopDetail.currentWaiting
            )
            tvShopDetailShopInfoName.text = shopDetail.name
            tvShopDetailShopInfoAddress.text = shopDetail.longAddress
            tvShopDetailInfoStar.text = shopDetail.averageStar.toString()
            includeShopDetailInfoStar.setRatingBar(shopDetail.averageStar)
            tvShopDetailInfoReviewCount.text = getString(
                R.string.shop_detail_review_count,
                shopDetail.reviewCount
            )
        }
    }

    private fun setShopDetailHome(shopDetail: ShopDetail) {
        with(binding) {
            tvShopDetailHomeSalesTime.text = shopDetail.salesTime
            tvShopDetailHomeReserve.text = shopDetail.waitingTime
            tvShopDetailHomeRestTime.text = shopDetail.restTime
            tvShopDetailHomeRestDay.text = shopDetail.restDay
            tvShopDetailHomePhoneNumber.text = shopDetail.phoneNumber

            val inflater = LayoutInflater.from(this@ShopDetailActivity)
            shopDetail.hashTagList.forEachIndexed { _, hashTag ->
                val chip = inflater.inflate(
                    R.layout.view_shop_detail_pick_chip,
                    binding.cgShopDetailHomeShopPick,
                    false
                ) as Chip
                chip.text = hashTag
                binding.cgShopDetailHomeShopPick.addView(chip)
            }

            tvShopDetailHomeIntroduceContent.text = shopDetail.introduceContent
        }
    }

    private fun setShopDetailMenuList(shopDetail: ShopDetail) {
        with(binding) {
            shopDetailMenuListAdapter = ShopDetailMenuListAdapter()
            rvShopDetailMenuList.adapter = shopDetailMenuListAdapter
            shopDetailMenuListAdapter.submitList(shopDetail.menuList)
            includeShopDetailMenuListDetailBtn.tvDetailBtn.text =
                getString(R.string.shop_detail_menu_list_full_menu_detail)
        }
    }

    private fun setShopDetailRecentReview(shopDetail: ShopDetail) {
        with(binding) {
            tvShopDetailRecentReviewTitle.text = getString(
                R.string.shop_detail_recent_review_title,
                shopDetail.reviewCount
            )
            tvShopDetailRecentReviewTotalStarContext.text = shopDetail.averageStar.toString()
            includeShopDetailRecentReviewTotalStar.setRatingBar(shopDetail.averageStar)

            includeShopDetailRecentReviewDetailStarFoodTaste.setData(
                this@ShopDetailActivity,
                StarType.FOOD_TASTE,
                shopDetail.detailStarList[FOOD_TASTE]
            )
            includeShopDetailRecentReviewDetailStarMood.setData(
                this@ShopDetailActivity,
                StarType.MOOD,
                shopDetail.detailStarList[MOOD]
            )
            includeShopDetailRecentReviewDetailStarKindness.setData(
                this@ShopDetailActivity,
                StarType.KINDNESS,
                shopDetail.detailStarList[KINDNESS]
            )
            includeShopDetailRecentReviewDetailStarCleanliness.setData(
                this@ShopDetailActivity,
                StarType.CLEANLINESS,
                shopDetail.detailStarList[CLEANLINESS]
            )

            shopDetailRecentReviewAdapter = ShopDetailRecentReviewAdapter()
            rvShopDetailRecentReview.adapter = shopDetailRecentReviewAdapter
            shopDetailRecentReviewAdapter.submitList(shopDetail.reviewList)
            includeShopDetailRecentReviewDetailBtn.tvDetailBtn.text =
                getString(R.string.shop_detail_recent_review_full_review_detail)
        }
    }

    private fun setTvShopDetailShopImgPageText(currentPage: Int) {
        binding.tvShopDetailShopImgPage.text = getString(
            R.string.shop_detail_shop_img_page,
            currentPage + 1,
            shopDetailShopImgAdapter.currentList.size
        )
    }

    companion object {
        const val FIRST_POSITION = 0
        const val Y_VALUE = 0
        const val FOOD_TASTE = 0
        const val MOOD = 1
        const val KINDNESS = 2
        const val CLEANLINESS = 3
        const val HOME = 0
        const val MENU_LIST = 1
        const val RECENT_REVIEW = 2
        const val VISIT_PERSON = "visitPersonBottomSheetDialogFragment"
    }
}
