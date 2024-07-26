package data.db.firebase

import data.db.db_repository.CustomDexRepository
import domain.models.CustomDex
import utils.Constants
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

internal class FirebaseCustomDexRepoImpl : CustomDexRepository {

    private val repository = FirebaseGenericRepository(CustomDex::class.java)
    override suspend fun getCustomDex(userId: String): List<CustomDex> {
        return suspendCoroutine {
            repository.getChildOfChildList(userId, Constants.DB_DEX, Constants.DB_CUSTOM_DEX) { result, error ->
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

    override suspend fun saveOrUpdateCustomDex(userId: String, customDex: CustomDex, dexName: String) {
        return suspendCoroutine {
            repository.saveChildOfChildByDexName(userId, Constants.DB_DEX, Constants.DB_CUSTOM_DEX, customDex, dexName) { _, error ->
                when {
                    error != null -> it.resumeWithException(error)
                    else -> it.resume(Unit)
                }
            }
        }
    }

    override suspend fun getCustomDexByDexName(userId: String, dexName: String): CustomDex {
        return suspendCoroutine {
            repository.getCustomDexByDexName(userId, Constants.DB_DEX, Constants.DB_CUSTOM_DEX, dexName) { result, error ->
                when {
                    error != null -> it.resumeWithException(error)
                    result != null -> it.resume(result)
                    else -> it.resumeWithException(NoSuchElementException(userId))
                }
            }
        }
    }
}