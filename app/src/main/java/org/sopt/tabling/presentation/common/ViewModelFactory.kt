package org.sopt.tabling.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.tabling.presentation.shopDetail.ShopDetailViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShopDetailViewModel::class.java)) {
            return ShopDetailViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
