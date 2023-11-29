package org.sopt.tabling.data.repository

import org.sopt.tabling.data.datasource.remote.ReserveDataSource
import org.sopt.tabling.data.model.request.RequestReserveDto
import org.sopt.tabling.domain.model.Reserve
import org.sopt.tabling.domain.repository.ReserveRepository

class ReserveRepositoryImpl(
    private val reserveDataSource: ReserveDataSource,
) : ReserveRepository {
    override suspend fun postReserve(shopId: Long, personCount: Int): Result<Reserve?> =
        runCatching {
            reserveDataSource.postReserve(
                RequestReserveDto(
                    shopId,
                    personCount
                )
            ).data?.toReserve()
        }
}
