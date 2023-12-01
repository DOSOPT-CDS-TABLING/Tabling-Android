package org.sopt.tabling.presentation.store

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.tabling.data.model.response.ResponsePopularStoreDto
import org.sopt.tabling.databinding.ItemPopularStoreBinding
import org.sopt.tabling.databinding.ItemPopularStoreWithTitleBinding

class PopularStoreAdapter(
    private val context: Context,
    private val moveToShopDetail: (Long) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var storeList = listOf<ResponsePopularStoreDto.StoreData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            POPULAR_STORE_WITH_TITLE -> PopularStoreWithTitleViewHolder(
                ItemPopularStoreWithTitleBinding.inflate(inflater, parent, false),
                moveToShopDetail
            )

            else -> PopularStoreViewHolder(
                ItemPopularStoreBinding.inflate(inflater, parent, false),
                moveToShopDetail
            )
        }
    }

    override fun getItemCount() = storeList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PopularStoreWithTitleViewHolder -> holder.onBind(storeList[position])
            is PopularStoreViewHolder -> holder.onBind(storeList[position])
        }
    }

    override fun getItemViewType(position: Int): Int = when(position) {
        FIRST_POSITION -> POPULAR_STORE_WITH_TITLE
        else -> POPULAR_STORE
    }
    fun setStoreList(storeDataList: List<ResponsePopularStoreDto.StoreData>) {
        storeList = storeDataList
        notifyDataSetChanged()
    }

    companion object {
        const val FIRST_POSITION = 0
        const val POPULAR_STORE_WITH_TITLE = 0
        const val POPULAR_STORE = 1
    }
}
