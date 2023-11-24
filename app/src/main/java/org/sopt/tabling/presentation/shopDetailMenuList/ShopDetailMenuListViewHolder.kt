package org.sopt.tabling.presentation.shopDetailMenuList

import androidx.recyclerview.widget.RecyclerView
import org.sopt.tabling.databinding.ItemShopDetailMenuListBinding
import org.sopt.tabling.domain.model.Menu

class ShopDetailMenuListViewHolder(
    private val binding: ItemShopDetailMenuListBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(menu: Menu) {
        with(binding) {
            tvItemShopDetailMenuListTitle.text = menu.menuCategory
            val shopDetailMenuAdapter = ShopDetailMenuAdapter()
            rvItemShopDetailMenuList.adapter = shopDetailMenuAdapter
            shopDetailMenuAdapter.submitList(menu.menuInfoList)
        }
    }
}
