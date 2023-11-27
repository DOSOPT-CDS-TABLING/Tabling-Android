package org.sopt.tabling.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseWaitingDetailDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val waitingDetailData: WaitingDetailData,
) {
    @Serializable
    data class WaitingDetailData(
        @SerialName("order_id")
        val orderId: Int,
        @SerialName("shop_name")
        val shopName: String,
        @SerialName("waiting_number")
        val waitingNumber: Int,
        @SerialName("before_count")
        val beforeCount: Int,
        @SerialName("order_date")
        val orderDate: String,
        @SerialName("person_count")
        val personCount: Int,
        @SerialName("order_status")
        val orderStatus: String,
        @SerialName("total_price")
        val totalPrice: Int,
        @SerialName("request_content")
        val requestContent: String,
    )
}
