package org.sopt.tabling.presentation.store

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.tabling.data.model.response.ResponsePopularStoreDto
import org.sopt.tabling.databinding.ItemPopularStoreBinding

class PopularStoreAdapter(
    private val context: Context,
    private val moveToShopDetail: (Long) -> Unit
) :
    RecyclerView.Adapter<PopularStoreViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var storeList = listOf<ResponsePopularStoreDto.StoreData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularStoreViewHolder {
        return PopularStoreViewHolder(
            ItemPopularStoreBinding.inflate(inflater, parent, false),
            moveToShopDetail
        )
    }

    override fun getItemCount() = storeList.size

    override fun onBindViewHolder(holder: PopularStoreViewHolder, position: Int) {
        holder.onBind(storeList[position])
    }

    fun setStoreList(storeDataList: List<ResponsePopularStoreDto.StoreData>) {
        storeList = storeDataList
        notifyDataSetChanged()
    }
}
