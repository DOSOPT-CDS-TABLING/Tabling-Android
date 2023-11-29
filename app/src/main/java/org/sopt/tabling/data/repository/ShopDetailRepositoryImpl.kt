package org.sopt.tabling.data.repository

import org.sopt.tabling.data.datasource.remote.ShopDetailDataSource
import org.sopt.tabling.domain.model.ShopDetail
import org.sopt.tabling.domain.repository.ShopDetailRepository

class ShopDetailRepositoryImpl(
    private val shopDetailDataSource: ShopDetailDataSource,
) : ShopDetailRepository {
    override suspend fun getShopDetail(shopId: Long): Result<ShopDetail?> = runCatching {
        shopDetailDataSource.getShopDetail(shopId).data?.toShopDetail()
    }
}
