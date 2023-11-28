package org.sopt.tabling.presentation.shopDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.tabling.databinding.ItemShopDetailMenuBinding
import org.sopt.tabling.domain.model.MenuInfo
import org.sopt.tabling.util.ItemDiffCallback

class ShopDetailMenuAdapter() : ListAdapter<MenuInfo, ShopDetailMenuViewHolder>(
    ItemDiffCallback<MenuInfo>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.menuId == new.menuId }
    )
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopDetailMenuViewHolder =
        ShopDetailMenuViewHolder(
            ItemShopDetailMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            parent.context
        )

    override fun onBindViewHolder(holder: ShopDetailMenuViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}
