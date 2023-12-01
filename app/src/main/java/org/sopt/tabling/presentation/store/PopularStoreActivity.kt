package org.sopt.tabling.presentation.store

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import org.sopt.tabling.R
import org.sopt.tabling.databinding.ActivityPopularStoreBinding
import org.sopt.tabling.presentation.shopDetail.ShopDetailActivity
import org.sopt.tabling.util.binding.BindingActivity

class PopularStoreActivity :
    BindingActivity<ActivityPopularStoreBinding>(R.layout.activity_popular_store) {
    private val storeViewModel by viewModels<StoreViewModel>()
    private lateinit var popularStoreAdapter: PopularStoreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.storeViewModel = storeViewModel

        storeViewModel.getPopularStoreList()
        initAdapter()
        setPopularStoreList()
    }

    private fun initAdapter() {
        popularStoreAdapter = PopularStoreAdapter(this, ::moveToShopDetail)
        binding.rvPopularStore.adapter = popularStoreAdapter
    }

    private fun setPopularStoreList() {
        storeViewModel.popularStoreList.observe(this) { storeList ->
            popularStoreAdapter.setStoreList(storeList)
        }
    }

    private fun moveToShopDetail(shopId: Long) {
        Intent(this@PopularStoreActivity, ShopDetailActivity::class.java).apply {
            putExtra(SHOP_ID, shopId)
            startActivity(this)
        }
    }

    companion object {
        const val SHOP_ID = "shopId"
    }
}
