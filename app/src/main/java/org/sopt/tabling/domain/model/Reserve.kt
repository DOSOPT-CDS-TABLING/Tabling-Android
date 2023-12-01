package org.sopt.tabling.domain.model

data class Reserve(
    val orderId: Long,
    val waitingNumber: Int,
    val beforeCount: Int,
    val shopName: String,
    val personCount: Int,
    val orderStatus: String
)
