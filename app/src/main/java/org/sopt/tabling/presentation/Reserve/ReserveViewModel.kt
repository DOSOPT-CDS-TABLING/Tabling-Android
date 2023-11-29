package org.sopt.tabling.presentation.Reserve

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ReserveViewModel() : ViewModel() {
    val personCount = MutableStateFlow("0")

    fun getPersonCountAsInt(): Int = Integer.parseInt(personCount.value)
}
