package data.domain_impl_repository

import data.db.factory.RepositoryFactoryProvider
import data.db.handleOperationWithErrorCode
import domain.error.ErrorHandler
import domain.models.Counter
import domain.use_cases.counters.GetCountersImpl
import domain.use_cases.counters.SaveOrUpdateCountersImpl
import utils.Constants
import utils.UtilsResult

internal class CounterRepositoryImpl :
    GetCountersImpl.CounterRepository,
    SaveOrUpdateCountersImpl.CountersRepository
{
    private val repositoryFactory  = RepositoryFactoryProvider.getFactory(Constants.DATABASE)
    private val counterRepository = repositoryFactory.createCounterRepository()

    override suspend fun get(userId: String): UtilsResult<Counter, ErrorHandler> {
        return handleOperationWithErrorCode {
            counterRepository.get(userId)
        }
    }

    override suspend fun save(userId: String, counters: List<String>): UtilsResult<Unit, ErrorHandler> {
        return handleOperationWithErrorCode {
            counterRepository.save(userId, counters)
        }
    }
}