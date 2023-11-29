package org.sopt.tabling.presentation.type

import androidx.annotation.StringRes
import org.sopt.tabling.R

enum class StarType(
    @StringRes val startTypeNameRes: Int
) {
    FOOD_TASTE(startTypeNameRes = R.string.shop_detail_recent_review_food_taste),
    MOOD(startTypeNameRes = R.string.shop_detail_recent_review_mood),
    KINDNESS(startTypeNameRes = R.string.shop_detail_recent_review_kindness),
    CLEANLINESS(startTypeNameRes = R.string.shop_detail_recent_review_cleanliness)
}
