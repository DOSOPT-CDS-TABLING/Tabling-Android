package org.sopt.tabling.util.extension

import java.text.DecimalFormat

fun changeToPriceFormat(price: Int): String = DecimalFormat("#,###").format(price)
