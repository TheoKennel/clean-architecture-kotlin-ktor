package data.repository

import data.firebase.counter.CountersFirebaseRepository
import data.handleFirebaseOperationWithErrorCode
import domain.error.ErrorHandler
import domain.models.Counter
import domain.use_cases.counters.GetCountersImpl
import domain.use_cases.counters.SaveOrUpdateCountersImpl
import utils.UtilsResult

internal class CounterRepositoryImpl(
    private val dbRepository : CountersFirebaseRepository
) :
    GetCountersImpl.CounterRepository,
    SaveOrUpdateCountersImpl.CountersRepository
{
    override suspend fun get(userId: String): UtilsResult<Counter, ErrorHandler> {
        return handleFirebaseOperationWithErrorCode {
            dbRepository.get(userId)
        }
    }

    override suspend fun save(userId: String, counters: List<String>): UtilsResult<Unit, ErrorHandler> {
        return handleFirebaseOperationWithErrorCode {
            dbRepository.save(userId, counters)
        }
    }
}