package org.sopt.tabling.presentation.waiting

import android.os.Bundle
import androidx.activity.viewModels
import org.sopt.tabling.R
import org.sopt.tabling.databinding.ActivityWaitingDetailBinding
import org.sopt.tabling.util.binding.BindingActivity

class WaitingDetailActivity :
    BindingActivity<ActivityWaitingDetailBinding>(R.layout.activity_waiting_detail) {
    private val waitingViewModel by viewModels<WaitingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View 연결 전 임의로 설정한 orderId
        val orderId = 2
        waitingViewModel.getWaitingDetail(orderId)
        setWaitingDetailList()
    }

    private fun setWaitingDetailList() {
        waitingViewModel.waitingDetail.observe(this) { waitingDetailList ->
            binding.waitingData = waitingDetailList
        }
    }
}
