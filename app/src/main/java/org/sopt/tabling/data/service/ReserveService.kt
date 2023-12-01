package org.sopt.tabling.data.service

import org.sopt.tabling.data.model.request.RequestReserveDto
import org.sopt.tabling.data.model.response.ResponseReserveDto
import org.sopt.tabling.util.BaseResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ReserveService {
    @POST("/orders/reserve")
    suspend fun postReserve(
        @Body requestReserveDto: RequestReserveDto
    ): BaseResponse<ResponseReserveDto>
}
