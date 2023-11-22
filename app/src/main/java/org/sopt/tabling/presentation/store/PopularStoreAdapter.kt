package org.sopt.tabling.presentation.store

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.tabling.data.model.response.ResponsePopularStoreDto
import org.sopt.tabling.databinding.ItemPopularStoreBinding

class PopularStoreAdapter(context: Context) :
    RecyclerView.Adapter<PopularStoreAdapter.PopularStoreViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var storeList = listOf<ResponsePopularStoreDto.StoreData>()

    inner class PopularStoreViewHolder(val binding: ItemPopularStoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(storeData: ResponsePopularStoreDto.StoreData) {
            binding.data = storeData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularStoreViewHolder {
        return PopularStoreViewHolder(ItemPopularStoreBinding.inflate(inflater, parent, false))
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
