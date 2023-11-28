package org.sopt.tabling.presentation.shopDetail

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.tabling.R
import org.sopt.tabling.databinding.ItemShopDetailMenuBinding
import org.sopt.tabling.domain.model.MenuInfo
import org.sopt.tabling.util.extension.changeToPriceFormat

class ShopDetailMenuViewHolder(
    private val binding: ItemShopDetailMenuBinding,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(menuInfo: MenuInfo) {
        with(binding) {
            ivItemShopDetailMenuImg.load(menuInfo.menuPhotoUrl)
            tvItemShopDetailMenuName.text = menuInfo.menuName
            tvItemShopDetailMenuPrice.text = context.getString(
                R.string.shop_detail_menu_list_price,
                changeToPriceFormat(menuInfo.price)
            )
        }
    }
}
