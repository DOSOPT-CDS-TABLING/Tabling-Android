package org.sopt.tabling.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.tabling.data.datasource.remote.DummyDataSource
import org.sopt.tabling.data.repository.DummyRepositoryImpl
import org.sopt.tabling.presentation.dummy.DummyViewModel
import org.sopt.tabling.presentation.shopDetail.ShopDetailViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DummyViewModel::class.java)) {
            return DummyViewModel(DummyRepositoryImpl(DummyDataSource())) as T
        } else if (modelClass.isAssignableFrom(ShopDetailViewModel::class.java)) {
            return ShopDetailViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
