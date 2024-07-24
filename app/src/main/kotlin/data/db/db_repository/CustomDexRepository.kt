package data.db.db_repository

import utils.UtilsResult
import domain.error.ErrorHandler
import domain.models.CustomDex

interface CustomDexRepository {
    suspend fun getCustomDex(userId: String): UtilsResult<CustomDex, ErrorHandler>
    suspend fun saveCustomDexList(userId: String, list : List<String>) : UtilsResult<Unit, ErrorHandler>
    suspend fun saveCustomDexString(userId: String, name: String): UtilsResult<Unit, ErrorHandler>
}