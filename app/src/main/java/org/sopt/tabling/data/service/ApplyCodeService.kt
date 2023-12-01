package org.sopt.tabling.data.service

import org.sopt.tabling.data.model.request.RequestApplyCodeDto
import org.sopt.tabling.data.model.response.ResponseApplyCodeDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PATCH

interface ApplyCodeService {
    @PATCH("/orders/complete")
    fun applyCode(
        @Body request: RequestApplyCodeDto,
    ): Call<ResponseApplyCodeDto>
}
