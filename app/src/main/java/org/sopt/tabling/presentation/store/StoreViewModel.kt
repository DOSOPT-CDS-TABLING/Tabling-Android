package org.sopt.tabling.presentation.store

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.tabling.data.ServicePool
import org.sopt.tabling.data.model.response.ResponsePopularStoreDto
import timber.log.Timber

class StoreViewModel : ViewModel() {
    private val _popularStoreList = MutableLiveData<List<ResponsePopularStoreDto.StoreData>>()
    val popularStoreList = _popularStoreList

    fun getPopularStoreList() {
        viewModelScope.launch {
            val response = runCatching { ServicePool.popularStoreService.getPopularStore() }
            response.onSuccess { data ->
                _popularStoreList.value = data.storeData.sortedBy { it.shopId }
            }.onFailure {
                Timber.tag("API").d("error")
            }
        }
    }
}
