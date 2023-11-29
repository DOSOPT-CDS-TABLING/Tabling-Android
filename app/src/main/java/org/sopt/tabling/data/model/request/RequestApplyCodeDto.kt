package org.sopt.tabling.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestApplyCodeDto(
    @SerialName("order_id")
    val orderId: Int
)
