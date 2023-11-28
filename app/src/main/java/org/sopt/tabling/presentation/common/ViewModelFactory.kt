package org.sopt.tabling.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.tabling.presentation.shopDetail.ShopDetailViewModel
import org.sopt.tabling.presentation.visitPerson.VisitPersonViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShopDetailViewModel::class.java)) {
            return ShopDetailViewModel() as T
        } else if (modelClass.isAssignableFrom(VisitPersonViewModel::class.java)) {
            return VisitPersonViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
