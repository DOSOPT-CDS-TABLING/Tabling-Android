package org.sopt.tabling.presentation.shopDetailHome

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.google.android.material.chip.Chip
import org.sopt.tabling.R
import org.sopt.tabling.databinding.FragmentShopDetailHomeBinding
import org.sopt.tabling.presentation.common.ViewModelFactory
import org.sopt.tabling.presentation.shopDetail.ShopDetailViewModel
import org.sopt.tabling.util.binding.BindingFragment

class ShopDetailHomeFragment :
    BindingFragment<FragmentShopDetailHomeBinding>(R.layout.fragment_shop_detail_home) {
    private val shopDetailViewModel: ShopDetailViewModel by viewModels { ViewModelFactory() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shopDetailViewModel = shopDetailViewModel

        initLayout()
    }

    private fun initLayout() {
        with(binding) {
            shopDetailViewModel?.let { shopDetailViewModel ->
                tvShopDetailHomeSalesTime.text = shopDetailViewModel.mockShopDetailInfo.salesTime
                tvShopDetailHomeReserve.text = shopDetailViewModel.mockShopDetailInfo.waitingTime
                tvShopDetailHomeRestTime.text = shopDetailViewModel.mockShopDetailInfo.restTime
                tvShopDetailHomeRestDay.text = shopDetailViewModel.mockShopDetailInfo.restDay
                tvShopDetailHomePhoneNumber.text =
                    shopDetailViewModel.mockShopDetailInfo.phoneNumber

                shopDetailViewModel.mockShopDetailInfo.hashTagList.forEachIndexed { index, hashTag ->
                    cgShopDetailHomeShopPick.addView(
                        Chip(
                            ContextThemeWrapper(
                                requireContext(),
                                R.style.Widget_Material3_Chip_Style_Radius99_Pick
                            )
                        ).apply {
                            text = hashTag
                            setTextAppearance(R.style.TextAppearance_Caption1_SemiBold)
                            setTextColor(ContextCompat.getColor(requireContext(), R.color.gray_400))
                            setEnsureMinTouchTargetSize(false)
                            chipBackgroundColor = ColorStateList.valueOf(
                                ContextCompat.getColor(
                                    requireContext(),
                                    R.color.white
                                )
                            )
                        }
                    )
                }

                tvShopDetailHomeIntroduceContent.text =
                    shopDetailViewModel.mockShopDetailInfo.introduceContent
            }
        }
    }
}
