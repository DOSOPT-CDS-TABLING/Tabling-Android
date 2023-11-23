package org.sopt.tabling.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponsePopularStoreDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val storeData: List<StoreData>,
) {
    @Serializable
    data class StoreData(
        @SerialName("shop_id")
        val shopId: Int,
        @SerialName("name")
        val name: String,
        @SerialName("average_star")
        val averageStar: Double,
        @SerialName("review_count")
        val reviewCount: Int,
        @SerialName("shop_category")
        val shopCategory: String,
        @SerialName("short_address")
        val shortAddress: String,
        @SerialName("average_waiting")
        val averageWaiting: Int,
        @SerialName("current_waiting")
        val currentWaiting: Int,
        @SerialName("profile_photo_url")
        val profilePhotoUrl: String,
    )
}
