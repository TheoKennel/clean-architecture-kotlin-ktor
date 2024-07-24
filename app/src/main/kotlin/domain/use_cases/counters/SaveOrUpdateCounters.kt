package domain.use_cases.counters

import domain.error.ErrorHandler
import domain.models.Counter
import utils.UtilsResult

fun interface SaveOrUpdateCounters {
    suspend operator fun invoke(userId: String, counters : List<Counter>): UtilsResult<Unit, ErrorHandler>
}

internal class SaveOrUpdateCountersImpl(
    private val countersRepository: CountersRepository,
) : SaveOrUpdateCounters {

    fun interface CountersRepository {

        suspend fun save(userId: String, counters : List<Counter>): UtilsResult<Unit, ErrorHandler>
    }

    override suspend fun invoke(userId: String, counters : List<Counter>): UtilsResult<Unit, ErrorHandler> =
        countersRepository.save(userId, counters)
}