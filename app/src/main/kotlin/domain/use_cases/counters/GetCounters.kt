package domain.use_cases.counters

import domain.error.ErrorHandler
import domain.models.Counter
import utils.UtilsResult

fun interface GetCounters {
    suspend operator fun invoke(userId: String): UtilsResult<List<Counter>, ErrorHandler>
}

internal class GetCountersImpl(
    private val counterRepository: CounterRepository,
) : GetCounters {

    fun interface CounterRepository {

        suspend fun get(userId: String): UtilsResult<List<Counter>, ErrorHandler>
    }

    override suspend fun invoke(userId: String): UtilsResult<List<Counter>, ErrorHandler> = counterRepository.get(userId)
}