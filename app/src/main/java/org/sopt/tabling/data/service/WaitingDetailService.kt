package org.sopt.tabling.data.service

import org.sopt.tabling.data.model.response.ResponseWaitingDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface WaitingDetailService {
    @GET("/orders/{order_id}")
    suspend fun getWaitingDetail(@Path("order_id") orderId: Int): ResponseWaitingDetailDto
}