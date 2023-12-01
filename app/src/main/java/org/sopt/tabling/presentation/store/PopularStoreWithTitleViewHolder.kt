package org.sopt.tabling.presentation.store

import androidx.recyclerview.widget.RecyclerView
import org.sopt.tabling.data.model.response.ResponsePopularStoreDto
import org.sopt.tabling.databinding.ItemPopularStoreWithTitleBinding

class PopularStoreWithTitleViewHolder(
    private val binding: ItemPopularStoreWithTitleBinding,
    private val moveToShopDetail: (Long) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(storeData: ResponsePopularStoreDto.StoreData) {
        binding.storeData = storeData
        binding.layoutPopularStore.setOnClickListener {
            moveToShopDetail(storeData.shopId.toLong())
        }
    }
}
