package org.sopt.tabling.util.extension

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
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

fun ImageView.setImageDrawableWithColorFilter(
    context: Context,
    drawableRes: Int,
    iconEvaluator: Int
) {
    setImageDrawable(
        ContextCompat.getDrawable(
            context,
            drawableRes
        )?.mutate()?.apply {
            colorFilter = PorterDuffColorFilter(iconEvaluator, PorterDuff.Mode.SRC_IN)
        }
    )
}
