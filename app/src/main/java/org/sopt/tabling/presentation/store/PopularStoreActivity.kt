package org.sopt.tabling.presentation.store

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import org.sopt.tabling.R
import org.sopt.tabling.databinding.ActivityPopularStoreBinding
import org.sopt.tabling.util.binding.BindingActivity

class PopularStoreActivity :
    BindingActivity<ActivityPopularStoreBinding>(R.layout.activity_popular_store) {
    private val storeViewModel by viewModels<StoreViewModel>()
    private lateinit var popularStoreAdapter: PopularStoreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.storeViewModel = storeViewModel

        storeViewModel.setDummyList()
        initAdapter()
        setPopularStoreList()
    }

    private fun initAdapter() {
        popularStoreAdapter = PopularStoreAdapter(this)
        binding.rvPopularStore.adapter = popularStoreAdapter
    }

    private fun setPopularStoreList() {
        storeViewModel.popularStoreList.observe(
            this,
            Observer { storeList ->
                popularStoreAdapter.setStoreList(storeList)
            }
        )
    }
}
