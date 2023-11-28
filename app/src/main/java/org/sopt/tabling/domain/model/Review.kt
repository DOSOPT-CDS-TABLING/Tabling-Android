package org.sopt.tabling.domain.model

data class Review(
    val reviewId: Long,
    val star: Float,
    val reviewerName: String,
    val dayBefore: Int,
    val reviewContent: String
)
