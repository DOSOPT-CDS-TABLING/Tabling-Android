package org.sopt.tabling.presentation.shopDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.tabling.databinding.ItemShopDetailReviewBinding
import org.sopt.tabling.domain.model.Review
import org.sopt.tabling.util.ItemDiffCallback

class ShopDetailRecentReviewAdapter() : ListAdapter<Review, ShopDetailRecentReviewViewHolder>(
    ItemDiffCallback<Review>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.reviewId == new.reviewId }
    )
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShopDetailRecentReviewViewHolder = ShopDetailRecentReviewViewHolder(
        ItemShopDetailReviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        parent.context
    )

    override fun onBindViewHolder(holder: ShopDetailRecentReviewViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}
