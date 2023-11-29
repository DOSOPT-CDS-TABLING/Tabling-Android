package org.sopt.tabling.domain.repository

import org.sopt.tabling.domain.model.ShopDetail

interface ShopDetailRepository {
    suspend fun getShopDetail(shopId: Long): Result<ShopDetail?>
}
