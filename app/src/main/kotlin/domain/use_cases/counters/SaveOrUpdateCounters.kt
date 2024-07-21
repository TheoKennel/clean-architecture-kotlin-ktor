package domain.use_cases.counters

import domain.error.ErrorHandler
import utils.UtilsResult

fun interface SaveOrUpdateCounters {
    suspend operator fun invoke(userId: String, counters: List<String>): UtilsResult<Unit, ErrorHandler>
}

internal class SaveOrUpdateCountersImpl(
    private val countersRepository: CountersRepository,
) : SaveOrUpdateCounters {

    fun interface CountersRepository {

        suspend fun save(userId: String, counters: List<String>): UtilsResult<Unit, ErrorHandler>
    }

    override suspend fun invoke(userId: String, counters: List<String>): UtilsResult<Unit, ErrorHandler> =
        countersRepository.save(userId, counters)
}