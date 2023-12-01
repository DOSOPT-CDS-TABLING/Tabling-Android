package org.sopt.tabling.data.service

import org.sopt.tabling.data.model.response.ResponsePopularStoreDto
import retrofit2.http.GET

interface PopularStoreService {
    @GET("/shops")
    suspend fun getPopularStore(): ResponsePopularStoreDto
}
