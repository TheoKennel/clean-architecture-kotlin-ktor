package data.repository

import domain.error.ErrorHandler
import domain.models.Counter
import domain.use_cases.counters.GetCountersImpl
import domain.use_cases.counters.SaveOrUpdateCountersImpl
import utils.UtilsResult

internal class CounterRepositoryImpl() :
    GetCountersImpl.CounterRepository,
    SaveOrUpdateCountersImpl.CountersRepository
{
    override suspend fun get(userId: String): UtilsResult<Counter, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun save(userId: String, counters: List<String>): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }
}