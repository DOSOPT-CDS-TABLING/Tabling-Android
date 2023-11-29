package org.sopt.tabling.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseReservationDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val reservationList: List<Reservation>,
) {
    @Serializable
    data class Reservation(
        @SerialName("order_id")
        val orderId: Int,
        @SerialName("order_status")
        val orderStatus: String,
        @SerialName("shop_id")
        val shopId: Long,
        @SerialName("shop_name")
        val shopName: String,
        @SerialName("order_date")
        val orderDate: String,
        @SerialName("person_count")
        val personCount: Int,
        @SerialName("waiting_number")
        val waitingNumber: Int,
        @SerialName("before_count")
        val beforeCount: Int,
        @SerialName("remaining_review_period")
        val remainingReviewPeriod: Int,
    )
}
