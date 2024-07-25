package data.db.firebase

import data.db.db_repository.CountersRepository
import domain.models.Counter
import utils.Constants
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

internal class FirebaseCounterRepoImpl : CountersRepository {

    private val repository = FirebaseGenericRepository(Counter::class.java)

    override suspend fun get(userId: String): List<Counter> {
        return suspendCoroutine {
            repository.getChildList(userId, Constants.DB_COUNTERS) { result, error ->
                when {
                    error != null -> it.resumeWithException(error)
                    result != null -> it.resume(result)
                    else -> it.resumeWithException(NoSuchElementException("No result found for userId: $userId"))
                }
            }
        }
    }

    override suspend fun save(userId: String, counter: List<Counter>) {
        return suspendCoroutine {
            repository.saveChildList(userId, Constants.DB_COUNTERS, counter) { _ , error ->
                when {
                    error != null -> it.resumeWithException(error)
                    else -> it.resume(Unit)
                }
            }
        }
    }
}
