package org.sopt.tabling.presentation.queue

import androidx.recyclerview.widget.RecyclerView
import org.sopt.tabling.databinding.ItemDoneReservationBinding
import org.sopt.tabling.domain.model.ReservationItem

class ReservationDoneViewHolder(private val binding: ItemDoneReservationBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: ReservationItem.ReservationDoneView) {
        binding.tvReservationDate.text = item.reserveDate
        binding.tvReservationPeople.text = item.reserveNum + "명"
        binding.tvStoreName.text = item.reserveName
        binding.tvRemainReviewNum.text = item.remainReviewNum + "일"
    }
}
