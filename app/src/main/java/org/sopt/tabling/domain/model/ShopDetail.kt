package org.sopt.tabling.domain.model

data class ShopDetail(
    val shopId: Long,
    val detailPhotoList: List<String>,
    val name: String,
    val longAddress: String,
    val currentWaiting: Int,
    val salesTime: String,
    val waitingTime: String,
    val restTime: String,
    val restDay: String,
    val phoneNumber: String,
    val hashTagList: List<String>,
    val introduceContent: String,
    val menuList: List<Menu>,
    val averageStar: Float,
    val reviewCount: Int,
    val detailStarList: List<Float>,
    val reviewList: List<Review>
)
