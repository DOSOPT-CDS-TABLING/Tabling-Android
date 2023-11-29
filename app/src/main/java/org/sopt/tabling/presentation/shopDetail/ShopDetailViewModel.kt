package org.sopt.tabling.presentation.shopDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.tabling.domain.model.ShopDetail
import org.sopt.tabling.domain.repository.ShopDetailRepository
import org.sopt.tabling.util.UiState

class ShopDetailViewModel(
    private val shopDetailRepository: ShopDetailRepository
) : ViewModel() {
    private val _getShopDetailState = MutableStateFlow<UiState<ShopDetail?>>(UiState.Empty)
    val getShopDetailState = _getShopDetailState.asStateFlow()

    init {
        getShopDetail()
    }

    private fun getShopDetail(shopId: Long = 2) {
        viewModelScope.launch {
            _getShopDetailState.value = UiState.Loading
            shopDetailRepository.getShopDetail(shopId).onSuccess { shopDetail ->
                _getShopDetailState.value = UiState.Success(shopDetail)
            }.onFailure { exception: Throwable ->
                _getShopDetailState.value = UiState.Error(exception.message)
            }
        }
    }
}
