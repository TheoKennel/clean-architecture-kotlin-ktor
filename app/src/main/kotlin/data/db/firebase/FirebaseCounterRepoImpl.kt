package data.db.firebase

import data.db.db_repository.CountersRepository
import domain.error.ErrorHandler
import domain.models.Counter
import utils.UtilsResult
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

internal class FirebaseCounterRepoImpl : CountersRepository {

    private val repository = FirebaseGenericRepository(Counter::class.java)

    override suspend fun get(userId: String): Counter {
        return suspendCoroutine {
            repository.getChild(userId, "counters") { result, error ->
                if (error != null || result == null) {
                    it.resumeWithException(error ?: Exception("Unknown Error"))
                }
                if (result == null) {
                    it.resumeWithException(Exception("Empty data"))
                } else {
                    it.resume(result)
                }
            }
        }
    }

    override suspend fun save(userId: String, counter: List<String>): Unit {
        TODO("Not yet implemented")
    }
}
