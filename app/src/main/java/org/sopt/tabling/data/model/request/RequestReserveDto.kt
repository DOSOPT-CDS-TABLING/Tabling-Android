package org.sopt.tabling.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestReserveDto(
    @SerialName("shop_id")
    val shopId: Long,
    @SerialName("person_count")
    val personCount: Int
)
