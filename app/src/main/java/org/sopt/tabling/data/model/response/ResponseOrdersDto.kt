package org.sopt.tabling.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseOrdersDto(
    @SerialName("order_id")
    val orderId: Int,
    @SerialName("order_status")
    val orderStatus: String,
)
