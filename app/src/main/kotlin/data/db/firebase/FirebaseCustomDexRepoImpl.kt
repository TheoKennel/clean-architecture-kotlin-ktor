package data.db.firebase

import data.db.db_repository.CustomDexRepository
import domain.models.CustomDex
import utils.Constants
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

internal class FirebaseCustomDexRepoImpl : CustomDexRepository {

    private val repository = FirebaseGenericRepository(CustomDex::class.java)
    override suspend fun getCustomDex(userId: String): CustomDex {
        return suspendCoroutine {
            repository.getChildOfChild(userId, Constants.DB_DEX, Constants.DB_CUSTOM_DEX) { result, error ->
                println("Result in getCustomDex $result")
                println("Error in getCustomDex $error")
                when {
                    error != null -> it.resumeWithException(error)
                    result != null -> it.resume(result)
                    else -> it.resumeWithException(NoSuchElementException(userId))
                }
            }
        }
    }

    override suspend fun saveOrUpdateCustomDex(userId: String, customDex: CustomDex) {
        return suspendCoroutine {
            repository.saveChildOfChild(userId, Constants.DB_DEX, Constants.DB_CUSTOM_DEX, customDex) { _, error ->
                when {
                    error != null -> it.resumeWithException(error)
                    else -> it.resume(Unit)
                }
            }
        }
    }
}