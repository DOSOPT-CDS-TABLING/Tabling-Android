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
        val shop_id: Int,
        @SerialName("name")
        val name: String,
        @SerialName("average_star")
        val average_star: Double,
        @SerialName("review_count")
        val review_count: Int,
        @SerialName("shop_category")
        val shop_category: String,
        @SerialName("short_address")
        val short_address: String,
        @SerialName("average_waiting")
        val average_waiting: Int,
        @SerialName("current_waiting")
        val current_waiting: Int,
        @SerialName("profile_photo_url")
        val profile_photo_url: String,
    )
}
