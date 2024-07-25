package domain.use_cases.counters

import domain.models.Counter

fun interface SaveOrUpdateCounters {
    suspend operator fun invoke(userId: String, counters : List<Counter>)
}

internal class SaveOrUpdateCountersImpl(
    private val countersRepository: CountersRepository,
) : SaveOrUpdateCounters {

    fun interface CountersRepository {

        suspend fun save(userId: String, counters : List<Counter>)
    }

    override suspend fun invoke(userId: String, counters : List<Counter>) =
        countersRepository.save(userId, counters)
}