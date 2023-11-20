package org.sopt.tabling.data.model.response

import kotlinx.serialization.Serializable
import org.sopt.tabling.domain.model.DummyData

@Serializable
data class ResponseDummyDto(
    val status: Int,
    val message: String,
    val data: ResponseData,
) {
    @Serializable
    data class ResponseData(
        val id: Int,
        val name: String,
        val email: String,
    ) {
        fun toDummyData() = DummyData(
            id = id.toString(),
            email = email,
            name = name
        )
    }
}
