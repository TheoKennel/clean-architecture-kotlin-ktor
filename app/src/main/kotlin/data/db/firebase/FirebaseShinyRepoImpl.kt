package data.db.firebase

import data.db.db_repository.ShinyRepository
import domain.models.ShinyCatch
import utils.Constants
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

internal class FirebaseShinyRepoImpl : ShinyRepository {

    private val repository = FirebaseGenericRepository(ShinyCatch::class.java)
    override suspend fun get(userId: String): List<ShinyCatch> {
        return suspendCoroutine {
            repository.getChildList(userId, Constants.DB_SHINY) { result, error ->
                when {
                    error != null -> it.resumeWithException(error)
                    result != null -> it.resume(result)
                    else -> it.resumeWithException(NoSuchElementException("No result found for userId: $userId"))
                }
            }
        }
    }

    override suspend fun saveOrUpdate(userId: String, shinyCatch: List<ShinyCatch>) {
        return suspendCoroutine {
            repository.saveChildList(userId, Constants.DB_SHINY, shinyCatch) { _, error ->
                when {
                    error != null -> it.resumeWithException(error)
                    else -> it.resume(Unit)
                }
            }
        }
    }
}
