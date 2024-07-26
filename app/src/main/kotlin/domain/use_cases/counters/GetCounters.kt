package domain.use_cases.counters

import domain.models.Counter
import domain.use_cases.user.GetUserById

fun interface GetCounters {
    suspend operator fun invoke(userId: String): List<Counter>
}

internal class GetCountersImpl(
    private val counterRepository: CounterRepository,
    private val getUserById: GetUserById,
) : GetCounters {

    fun interface CounterRepository {

        suspend fun get(userId: String): List<Counter>
    }

    override suspend fun invoke(userId: String): List<Counter> {
        val result = getUserById.invoke(userId)
        return result.counters ?: emptyList()
    }
}