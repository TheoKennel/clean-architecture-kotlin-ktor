package di.domain

import dagger.Module
import dagger.Provides
import data.repository.CounterRepositoryImpl
import domain.use_cases.counters.GetCounters
import domain.use_cases.counters.GetCountersImpl
import domain.use_cases.counters.SaveOrUpdateCounters
import domain.use_cases.counters.SaveOrUpdateCountersImpl
import javax.inject.Singleton

@Module
internal class CountersDomainModule {

    @Provides
    @Singleton
    fun provideGetCounters(
        repository: CounterRepositoryImpl
    ) : GetCounters {
        return GetCountersImpl(repository)
    }

    @Provides
    @Singleton
    fun provideSaveOrUpdateCounters(
        repository: CounterRepositoryImpl
    ) : SaveOrUpdateCounters {
        return SaveOrUpdateCountersImpl(repository)
    }
}