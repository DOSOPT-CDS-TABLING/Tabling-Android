package org.sopt.tabling.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestDummyDto(
    @SerialName("name")
    val name: String,
    @SerialName("email")
    val email: String,
)
