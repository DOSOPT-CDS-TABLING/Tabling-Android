package org.sopt.tabling.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestOrdersDto(
    // 이 부분 필요 없는 코드인가욥?
    @SerialName("Content-Type")
    val type : String = "application/json"
)
