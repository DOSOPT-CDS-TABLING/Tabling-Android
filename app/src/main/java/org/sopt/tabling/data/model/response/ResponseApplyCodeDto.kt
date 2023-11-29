package org.sopt.tabling.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseApplyCodeDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<Data>,
) {
    @Serializable
    data class Data(
        @SerialName("order_id")
        val orderId: Int,
        @SerialName("waiting_number")
        val waitingNumber: Int,
        @SerialName("before_count")
        val beforeCount: Int,
        @SerialName("shop_name")
        val shopName: String,
        @SerialName("person_count")
        val personCount: Int,
        @SerialName("order_status")
        val orderStatus: String,
    )
}
