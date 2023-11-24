package org.sopt.tabling.presentation.shopDetailMenuList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.tabling.databinding.ItemShopDetailMenuListBinding
import org.sopt.tabling.domain.model.Menu
import org.sopt.tabling.util.ItemDiffCallback

class ShopDetailMenuListAdapter() : ListAdapter<Menu, ShopDetailMenuListViewHolder>(
    ItemDiffCallback<Menu>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.menuCategory == new.menuCategory }
    )
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShopDetailMenuListViewHolder =
        ShopDetailMenuListViewHolder(
            ItemShopDetailMenuListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ShopDetailMenuListViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}
