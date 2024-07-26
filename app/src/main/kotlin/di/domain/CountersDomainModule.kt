package di.domain

import dagger.Module
import dagger.Provides
import data.domain_impl_repository.CounterRepositoryImpl
import domain.use_cases.counters.GetCounters
import domain.use_cases.counters.GetCountersImpl
import domain.use_cases.counters.SaveOrUpdateCounters
import domain.use_cases.counters.SaveOrUpdateCountersImpl
import domain.use_cases.user.GetUserById
import javax.inject.Singleton

@Module
internal class CountersDomainModule {

    @Provides
    @Singleton
    fun provideGetCounters(
        repository: CounterRepositoryImpl,
        getUserById: GetUserById,
    ) : GetCounters {
        return GetCountersImpl(repository, getUserById)
    }

    @Provides
    @Singleton
    fun provideSaveOrUpdateCounters(
        repository: CounterRepositoryImpl
    ) : SaveOrUpdateCounters {
        return SaveOrUpdateCountersImpl(repository)
    }
}