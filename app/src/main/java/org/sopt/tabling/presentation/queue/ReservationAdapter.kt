package org.sopt.tabling.presentation.queue

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.tabling.databinding.ReservationItemBinding
import org.sopt.tabling.databinding.ReservationItemDoneBinding
import org.sopt.tabling.domain.model.ReservationItem
import java.lang.RuntimeException

class ReservationAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var reservationList: List<ReservationItem> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> ReservationViewHolder(
                ReservationItemBinding.inflate(inflater, parent, false)
            )

            2 -> ReservationDoneViewHolder(
                ReservationItemDoneBinding.inflate(inflater, parent, false)
            )

            else -> throw RuntimeException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ReservationViewHolder -> holder.onBind(reservationList[position] as ReservationItem.ReservationView)
            is ReservationDoneViewHolder -> holder.onBind(reservationList[position] as ReservationItem.ReservationDoneView)
        }
    }


    override fun getItemViewType(position: Int): Int {
        return when (reservationList[position]) {
            is ReservationItem.ReservationView -> 1
            is ReservationItem.ReservationDoneView -> 2
        }
    }

    override fun getItemCount(): Int = reservationList.size

    fun setReservationList(mockReservationList: List<ReservationItem>) {
        reservationList = mockReservationList
        notifyDataSetChanged()
    }
}
