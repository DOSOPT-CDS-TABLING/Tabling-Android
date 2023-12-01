package org.sopt.tabling.data.service

import org.sopt.tabling.data.model.response.ResponseReservationDto
import retrofit2.Call
import retrofit2.http.GET

interface ReservationListService {
    @GET("/orders")
    fun getReservationList(): Call<ResponseReservationDto>
}
