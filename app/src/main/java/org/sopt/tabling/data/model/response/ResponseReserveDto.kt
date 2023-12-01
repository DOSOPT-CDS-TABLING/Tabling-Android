package org.sopt.tabling.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.sopt.tabling.domain.model.Reserve

@Serializable
data class ResponseReserveDto(
    @SerialName("order_id")
    val orderId: Long,
    @SerialName("waiting_number")
    val waitingNumber: Int,
    @SerialName("before_count")
    val beforeCount: Int,
    @SerialName("shop_name")
    val shopName: String,
    @SerialName("person_count")
    val personCount: Int,
    @SerialName("order_status")
    val orderStatus: String
) {
    fun toReserve() = Reserve(
        orderId = this.orderId,
        waitingNumber = this.waitingNumber,
        beforeCount = this.beforeCount,
        shopName = this.shopName,
        personCount = this.personCount,
        orderStatus = this.orderStatus
    )
}
