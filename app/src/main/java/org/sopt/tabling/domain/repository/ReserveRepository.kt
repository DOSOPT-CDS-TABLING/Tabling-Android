package org.sopt.tabling.domain.repository

import org.sopt.tabling.domain.model.Reserve

interface ReserveRepository {
    suspend fun postReserve(
        shopId: Long,
        personCount: Int
    ): Result<Reserve?>
}
