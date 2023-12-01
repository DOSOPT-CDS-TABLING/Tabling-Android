package org.sopt.tabling.presentation.waiting

import android.os.Bundle
import androidx.activity.viewModels
import org.sopt.tabling.R
import org.sopt.tabling.databinding.ActivityWaitingDetailBinding
import org.sopt.tabling.presentation.queue.QueueReservationFragment.Companion.ORDER_ID
import org.sopt.tabling.util.binding.BindingActivity

class WaitingDetailActivity :
    BindingActivity<ActivityWaitingDetailBinding>(R.layout.activity_waiting_detail) {
    private val waitingViewModel by viewModels<WaitingViewModel>()
    private var orderId: Long = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        orderId = intent.getLongExtra(ORDER_ID, -1)

        initLayout()
        setWaitingDetailList()
    }

    private fun initLayout() {
        waitingViewModel.getWaitingDetail(orderId)
    }

    private fun setWaitingDetailList() {
        waitingViewModel.waitingDetail.observe(this) { waitingDetail ->
            binding.waitingData = waitingDetail
        }
    }
}
