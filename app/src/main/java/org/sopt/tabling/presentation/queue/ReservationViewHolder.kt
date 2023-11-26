package org.sopt.tabling.presentation.queue

import androidx.recyclerview.widget.RecyclerView
import org.sopt.tabling.databinding.ReservationItemBinding
import org.sopt.tabling.domain.model.ReservationItem

class ReservationViewHolder(private val binding: ReservationItemBinding) :
RecyclerView.ViewHolder(binding.root){
    fun onBind(item: ReservationItem.ReservationView){
        binding.tvReservationDate.text = item.reservationDate
        binding.tvReservationPeople.text = item.reserveNum + "명"
        binding.tvStoreName.text = item.reserveName
        binding.tvWaitingNum.text = item.waitingNum
        binding.tvWaitingInfoNum.text = item.realWaitNum
    }
}