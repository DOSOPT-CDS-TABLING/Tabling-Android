package org.sopt.tabling.data.service

import org.sopt.tabling.data.model.response.ResponseShopDetailDto
import org.sopt.tabling.util.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ShopDetailService {
    @GET("/shops/{shop_id}")
    suspend fun getShopDetail(
        @Path("shop_id") shopId: Long
    ): BaseResponse<ResponseShopDetailDto>
}
