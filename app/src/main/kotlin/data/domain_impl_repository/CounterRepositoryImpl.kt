package data.domain_impl_repository

import data.db.factory.RepositoryFactoryProvider
import domain.models.Counter
import domain.use_cases.counters.GetCountersImpl
import domain.use_cases.counters.SaveOrUpdateCountersImpl
import utils.Constants

internal class CounterRepositoryImpl :
    GetCountersImpl.CounterRepository,
    SaveOrUpdateCountersImpl.CountersRepository
{
    private val repositoryFactory = RepositoryFactoryProvider.getFactory(Constants.DATABASE)
    private val counterRepository = repositoryFactory.createCounterRepository()

    override suspend fun get(userId: String): List<Counter> = counterRepository.get(userId)

    override suspend fun save(userId: String, counters: List<Counter>) = counterRepository.save(userId, counters)
}