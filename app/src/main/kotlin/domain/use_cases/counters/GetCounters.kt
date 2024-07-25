package domain.use_cases.counters

import domain.models.Counter

fun interface GetCounters {
    suspend operator fun invoke(userId: String): List<Counter>
}

internal class GetCountersImpl(
    private val counterRepository: CounterRepository,
) : GetCounters {

    fun interface CounterRepository {

        suspend fun get(userId: String): List<Counter>
    }

    override suspend fun invoke(userId: String): List<Counter> = counterRepository.get(userId)
}