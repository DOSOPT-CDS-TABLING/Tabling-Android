package org.sopt.tabling.presentation.shopDetailRecentReview

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import org.sopt.tabling.R
import org.sopt.tabling.databinding.ItemShopDetailReviewBinding
import org.sopt.tabling.domain.model.Review
import org.sopt.tabling.util.extension.setRatingBar

class ShopDetailRecentReviewViewHolder(
    private val binding: ItemShopDetailReviewBinding,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(review: Review) {
        with(binding) {
            includeItemShopDetailReviewRatingBar.setRatingBar(review.star)
            tvItemShopDetailReviewStar.text = review.star.toString()
            tvItemShopDetailReviewReviewerName.text = review.reviewerName
            tvItemShopDetailReviewDayBefore.text =
                context.getString(R.string.shop_detail_recent_review_day_before, review.dayBefore)
            tvItemShopDetailReviewContent.text = review.reviewContent
        }
    }
}
