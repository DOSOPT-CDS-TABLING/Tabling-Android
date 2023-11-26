package org.sopt.tabling.presentation.waiting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.tabling.data.model.response.ResponseWaitingDetailDto

class WaitingViewModel : ViewModel() {
    private val _waitingDetail =
        MutableLiveData<ResponseWaitingDetailDto.WaitingDetailData>()
    val waitingDetail: LiveData<ResponseWaitingDetailDto.WaitingDetailData> = _waitingDetail

    init {
        _waitingDetail.value =
            ResponseWaitingDetailDto.WaitingDetailData(
                1,
                "파이브가이즈 여의도",
                66,
                4,
                "2023-11-21 (화) 11:23",
                2,
                "이용 예정",
                0,
                "맛있어요",
            )
    }
}
