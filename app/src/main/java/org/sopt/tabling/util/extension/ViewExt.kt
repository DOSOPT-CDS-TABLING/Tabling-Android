package org.sopt.tabling.util.extension

import android.view.View
import com.google.android.material.snackbar.Snackbar
import org.sopt.tabling.databinding.ViewRatingBarBinding

fun View.showSnackbar(message: String, isShort: Boolean = true) {
    val duration = if (isShort) Snackbar.LENGTH_SHORT else Snackbar.LENGTH_LONG
    Snackbar.make(this, message, duration).show()
}

fun ViewRatingBarBinding.setRatingBar(rating: Float) {
    ivRatingBarFirst.isEnabled = (1 <= rating)
    ivRatingBarSecond.isEnabled = (2 <= rating)
    ivRatingBarThird.isEnabled = (3 <= rating)
    ivRatingBarFourth.isEnabled = (4 <= rating)
    ivRatingBarFifth.isEnabled = (5 <= rating)
}
