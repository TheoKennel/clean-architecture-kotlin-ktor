package data.db.firebase

import data.db.db_repository.CountersRepository
import domain.error.ErrorHandler
import domain.models.Counter
import utils.Result
import utils.UtilsResult
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

internal class FirebaseCounterRepoImpl : CountersRepository {

    private val repository = FirebaseGenericRepository(Counter::class.java)

    override suspend fun get(userId: String): UtilsResult<Counter, ErrorHandler> {
        return suspendCoroutine { it ->
            repository.getChild(userId, "counters") { result, error ->
                if (error != null || result == null) {
                    it.resume(Result.Error(ErrorHandler.NetworkError))
                }
            }
        }
    }

    override suspend fun save(userId: String, counter: List<String>): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }