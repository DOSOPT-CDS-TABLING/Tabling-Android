package org.sopt.tabling.presentation.shopDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.tabling.databinding.ItemShopDetailShopImgBinding
import org.sopt.tabling.util.ItemDiffCallback

class ShopDetailShopImgAdapter() : ListAdapter<String, ShopDetailShopImgViewHolder>(
    ItemDiffCallback<String>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old == new }
    )
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopDetailShopImgViewHolder =
        ShopDetailShopImgViewHolder(
            ItemShopDetailShopImgBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ShopDetailShopImgViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}
