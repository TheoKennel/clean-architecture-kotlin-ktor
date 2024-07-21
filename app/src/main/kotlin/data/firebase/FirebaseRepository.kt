package data.firebase

import domain.error.ErrorHandler
import utils.UtilsResult

interface FirebaseRepository<T> {
    suspend fun get(userId: String): UtilsResult<T, ErrorHandler>
    suspend fun saveOrUpdate(userId: String, data: T): UtilsResult<Unit, ErrorHandler>
}