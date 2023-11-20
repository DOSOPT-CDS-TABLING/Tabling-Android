package org.sopt.tabling.data.repository

import org.sopt.tabling.data.datasource.remote.DummyDataSource
import org.sopt.tabling.domain.repository.DummyRepository

class DummyRepositoryImpl(val dummyDataSource: DummyDataSource) : DummyRepository {
    // TODO 서버통신 기초 세팅 이후 추가하겠음 !
}
