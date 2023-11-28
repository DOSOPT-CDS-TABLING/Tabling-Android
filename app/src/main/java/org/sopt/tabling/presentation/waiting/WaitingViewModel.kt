package org.sopt.tabling.presentation.waiting

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.tabling.data.ServicePool
import org.sopt.tabling.data.model.response.ResponseWaitingDetailDto
import timber.log.Timber

class WaitingViewModel : ViewModel() {
    private val _waitingDetail =
        MutableLiveData<ResponseWaitingDetailDto.WaitingDetailData>()
    val waitingDetail: LiveData<ResponseWaitingDetailDto.WaitingDetailData> = _waitingDetail

    fun getWaitingDetail(orderId: Int) {
        viewModelScope.launch {
            val response = kotlin.runCatching { ServicePool.waitingDetailService.getWaitingDetail(orderId) }

            response.onSuccess { data ->
                _waitingDetail.value = data.waitingDetailData
            }.onFailure {
                Timber.d("서버 통신의 에러발생")
            }

        }
    }
}
