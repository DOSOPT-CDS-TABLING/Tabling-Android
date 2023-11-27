package org.sopt.tabling.presentation.common

import androidx.lifecycle.ViewModel
import org.sopt.tabling.domain.model.ReservationItem

class ReservationViewModel : ViewModel() {
    // 가짜 데이터(이용예정)
    val mockReservationList = listOf(
        ReservationItem.ReservationView(
            reservationDate = "11월 24일 (금)",
            reserveNum = "2",
            reserveName = "파이브가이즈 여의도",
            waitingNum = "42",
            realWaitNum = "15",
        ),
        ReservationItem.ReservationView(
            reservationDate = "11월 24일 (금)",
            reserveNum = "1",
            reserveName = "영덕집",
            waitingNum = "10",
            realWaitNum = "10",
        ),
        ReservationItem.ReservationDoneView(
            reserveDate = "11월 24일 (금)",
            reserveName = "영덕집",
            reserveNum = "4",
            remainReviewNum = "3",
        ),
        ReservationItem.ReservationDoneView(
            reserveDate = "11월 24일 (금)",
            reserveName = "봄불고기",
            reserveNum = "3",
            remainReviewNum = "3",
        ),
        ReservationItem.ReservationDoneView(
            reserveDate = "11월 24일 (금)",
            reserveName = "요요마의 키친",
            reserveNum = "2",
            remainReviewNum = "3",
        ),
    )
}
