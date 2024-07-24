package data.db.firebase

import data.db.db_repository.CountersRepository
import domain.models.Counter
import java.util.logging.Logger
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

internal class FirebaseCounterRepoImpl : CountersRepository {

    private val repository = FirebaseGenericRepository(Counter::class.java)
    private val logger = Logger.getLogger(FirebaseCounterRepoImpl::class.java.name)


    override suspend fun get(userId: String): List<Counter> {
        return suspendCoroutine {
            repository.getChildList(userId, "counters") { result, error ->
                if (error != null) {
                    logger.severe("Error fetching counters for user $userId: ${error.message}")
                    it.resumeWithException(error)
                }
                if (result == null) {
                    logger.warning("No counters found for user $userId")
                    it.resumeWithException(Exception("Empty data"))
                } else {
                    logger.info("Successfully fetched counters for user $userId: ${result}")
                    it.resume(result)
                }
            }
        }
    }

    override suspend fun save(userId: String, counter: List<Counter>) {
        return suspendCoroutine {
            repository.saveChildList(userId, "counters", counter) { _ , error ->
                if (error != null) {
                    it.resumeWithException(error)
                } else {
                    it.resume(Unit)
                }
            }
        }
    }
}
