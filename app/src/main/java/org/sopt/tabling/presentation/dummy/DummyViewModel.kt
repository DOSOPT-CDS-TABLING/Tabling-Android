package org.sopt.tabling.presentation.dummy

import androidx.lifecycle.ViewModel
import org.sopt.tabling.data.repository.DummyRepositoryImpl

class DummyViewModel(
    private val dummyRepositoryImpl: DummyRepositoryImpl
) : ViewModel() {
    // TODO 서버통신 관련 로직 작성
}
