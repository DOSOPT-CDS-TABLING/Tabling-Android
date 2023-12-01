package org.sopt.tabling.presentation.queue

import androidx.recyclerview.widget.RecyclerView
import org.sopt.tabling.data.model.response.ResponseReservationDto
import org.sopt.tabling.databinding.ItemReservationBinding

class ReservationViewHolder(
    private val binding: ItemReservationBinding,
    private val patchOnClick: (Int) -> Unit,
    private val moveToWaiting: (Long) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: ResponseReservationDto.Reservation) {
        binding.chipReservationWait.text = item.orderStatus
        binding.tvReservationDate.text = item.orderDate
        binding.tvReservationPeople.text = item.personCount.toString() + "명"
        binding.tvStoreName.text = item.shopName
        binding.tvWaitingNum.text = item.waitingNumber.toString()
        binding.tvWaitingInfoNum.text = item.beforeCount.toString() + "팀"

        binding.btnCode.setOnClickListener {
            patchOnClick(item.orderId)
        }

        binding.tvShowDetail.setOnClickListener {
            moveToWaiting(item.orderId.toLong())
        }
    }
}
