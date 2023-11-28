package org.sopt.tabling.presentation.visitPerson

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class VisitPersonViewModel : ViewModel() {
    val personCount = MutableStateFlow("0")

    fun getPersonCountAsInt(): Int = Integer.parseInt(personCount.value)
}
