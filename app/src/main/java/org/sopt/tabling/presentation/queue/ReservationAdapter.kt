package org.sopt.tabling.presentation.queue

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.tabling.data.model.response.ResponseReservationDto
import org.sopt.tabling.databinding.ItemDoneReservationBinding
import org.sopt.tabling.databinding.ItemNoneReservationBinding
import org.sopt.tabling.databinding.ItemReservationBinding

class ReservationAdapter(
    context: Context,
    private val patchOnClick: (Int) -> Unit,
    private val moveToWaiting: (Long) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var reservationList: List<ResponseReservationDto.Reservation> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> ReservationViewHolder(
                ItemReservationBinding.inflate(inflater, parent, false),
                patchOnClick,
                moveToWaiting
            )

            2 -> ReservationDoneViewHolder(
                ItemDoneReservationBinding.inflate(inflater, parent, false),
                moveToWaiting
            )

            3 -> ReservationNoneViewHolder(
                ItemNoneReservationBinding.inflate(inflater, parent, false),
                moveToWaiting
            )

            else -> throw RuntimeException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ReservationViewHolder -> holder.onBind(reservationList[position])
            is ReservationDoneViewHolder -> holder.onBind(reservationList[position])
            is ReservationNoneViewHolder -> holder.onBind(reservationList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (reservationList[position].orderStatus == "이용 예정") {
            return 1
        } else if (reservationList[position].orderStatus == "이용 완료") {
            if (reservationList[position].remainingReviewPeriod <= 0) {
                return 3
            }
            return 2
        } else {
            return 1
        }
    }

    override fun getItemCount(): Int = reservationList.size

    fun setReservationList(reservationItemList: List<ResponseReservationDto.Reservation>) {
        reservationList = reservationItemList
        notifyDataSetChanged()
    }
}
