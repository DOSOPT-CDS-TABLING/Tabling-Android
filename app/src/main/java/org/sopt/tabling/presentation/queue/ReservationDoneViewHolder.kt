package org.sopt.tabling.presentation.queue

import androidx.recyclerview.widget.RecyclerView
import org.sopt.tabling.data.model.response.ResponseReservationDto
import org.sopt.tabling.databinding.ItemDoneReservationBinding

class ReservationDoneViewHolder(private val binding: ItemDoneReservationBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: ResponseReservationDto.Reservation) {
        binding.chipReservationWait.text = item.orderStatus
        binding.tvReservationDate.text = item.orderDate
        binding.tvReservationPeople.text = item.personCount.toString() + "명"
        binding.tvStoreName.text = item.shopName
        binding.tvRemainReviewNum.text = item.remainingReviewPeriod.toString() + "일"
    }
}
