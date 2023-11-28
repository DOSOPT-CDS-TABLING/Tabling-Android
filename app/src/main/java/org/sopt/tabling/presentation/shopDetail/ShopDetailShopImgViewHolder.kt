package org.sopt.tabling.presentation.shopDetail

import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.tabling.databinding.ItemShopDetailShopImgBinding

class ShopDetailShopImgViewHolder(
    private val binding: ItemShopDetailShopImgBinding
) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(img: String) {
        with(binding) {
            ivItemShopDetailShopImg.load(img)
        }
    }
}
