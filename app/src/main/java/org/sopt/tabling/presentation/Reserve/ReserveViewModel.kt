package org.sopt.tabling.presentation.reserve

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.tabling.domain.model.Reserve
import org.sopt.tabling.domain.repository.ReserveRepository
import org.sopt.tabling.util.UiState

class ReserveViewModel(
    private val reserveRepository: ReserveRepository
) : ViewModel() {
    private val _postReserveState = MutableStateFlow<UiState<Reserve?>>(UiState.Empty)
    val postReserveState = _postReserveState.asStateFlow()
    val personCount = MutableStateFlow("0")

    fun getPersonCountAsInt(): Int = Integer.parseInt(personCount.value)

    fun postReserve(shopId: Long) {
        viewModelScope.launch {
            _postReserveState.value = UiState.Loading
            reserveRepository.postReserve(shopId, getPersonCountAsInt())
                .onSuccess { reserve ->
                    _postReserveState.value = UiState.Success(reserve)
                }
                .onFailure { exception: Throwable ->
                    _postReserveState.value = UiState.Error(exception.message)
                }
        }
    }
}
