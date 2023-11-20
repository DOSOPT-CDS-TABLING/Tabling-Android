package org.sopt.tabling.presentation.store

import android.os.Bundle
import androidx.activity.viewModels
import org.sopt.tabling.R
import org.sopt.tabling.databinding.ActivityPopularStoreBinding
import org.sopt.tabling.util.binding.BindingActivity

class PopularStoreActivity :
    BindingActivity<ActivityPopularStoreBinding>(R.layout.activity_popular_store) {
    private val storeViewModel by viewModels<StoreViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.storeViewModel = storeViewModel
    }
}