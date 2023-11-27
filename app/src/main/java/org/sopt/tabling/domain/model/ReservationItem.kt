package org.sopt.tabling.domain.model

sealed class ReservationItem {
    data class ReservationView(
        val reservationDate: String,
        val reserveNum: String,
        val reserveName: String,
        val waitingNum: String,
        val realWaitNum: String
    ) : ReservationItem()

    data class ReservationDoneView(
        val reserveDate: String,
        val reserveNum: String,
        val reserveName: String,
        val remainReviewNum: String
    ) : ReservationItem()
}
