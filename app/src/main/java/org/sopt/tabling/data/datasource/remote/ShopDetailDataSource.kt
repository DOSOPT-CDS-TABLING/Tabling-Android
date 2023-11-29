package org.sopt.tabling.data.datasource.remote

import org.sopt.tabling.data.ServicePool

class ShopDetailDataSource {
    private val shopDetailService = ServicePool.shopDetailService

    suspend fun getShopDetail(shopId: Long) = shopDetailService.getShopDetail(shopId)
}
