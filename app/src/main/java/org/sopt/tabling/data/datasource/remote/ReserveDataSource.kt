package org.sopt.tabling.data.datasource.remote

import org.sopt.tabling.data.ServicePool
import org.sopt.tabling.data.model.request.RequestReserveDto

class ReserveDataSource {
    private val reserveService = ServicePool.reserveService

    suspend fun postReserve(
        requestReserveDto: RequestReserveDto
    ) = reserveService.postReserve(requestReserveDto)
}
