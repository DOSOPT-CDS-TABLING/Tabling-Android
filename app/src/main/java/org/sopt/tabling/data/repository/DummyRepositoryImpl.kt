package org.sopt.tabling.data.repository

import org.sopt.tabling.data.datasource.remote.DummyDataSource
import org.sopt.tabling.domain.repository.DummyRepository

class DummyRepositoryImpl(val DummyDataSource: DummyDataSource) : DummyRepository {
}
