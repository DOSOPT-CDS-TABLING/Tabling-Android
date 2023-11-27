package org.sopt.tabling.presentation.reportCompleted

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ReportCompletedViewModel : ViewModel() {
    val personCount = MutableStateFlow("0")

    fun getPersonCountAsInt(): Int = Integer.parseInt(personCount.value)
}
