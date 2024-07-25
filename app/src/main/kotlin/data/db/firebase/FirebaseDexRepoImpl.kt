package data.db.firebase

import data.db.db_repository.DexRepository
import domain.models.Dex
import utils.Constants
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

internal class FirebaseDexRepoImpl : DexRepository {

    private val repository = FirebaseGenericRepository(Dex::class.java)

    override suspend fun get(userId: String): Dex {
        return suspendCoroutine {
            repository.getChild(userId, Constants.DB_DEX) { result, error ->
                when {
                    error != null -> it.resumeWithException(error)
                    result != null -> it.resume(result)
                    else -> it.resumeWithException(NoSuchElementException("No result found for userId: $userId"))
                }
            }
        }
    }

    override suspend fun saveOrUpdate(userId: String, dex: Dex) {
        return suspendCoroutine {
            repository.saveChild(userId, Constants.DB_DEX, dex) {_, error ->
                when {
                    error != null -> it.resumeWithException(error)
                    else -> it.resume(Unit)
                }
            }
        }
    }
}
