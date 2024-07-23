package data.db.db_repository

import utils.UtilsResult
import domain.error.ErrorHandler
import domain.models.CustomDex

interface CustomGetRepository {
    suspend fun getCustomDex(userId: String): UtilsResult<CustomDex, ErrorHandler>
    suspend fun getFirstFilterList(userId: String): UtilsResult<List<String>, ErrorHandler>
    suspend fun getPkmCatch(userId: String): UtilsResult<List<String>, ErrorHandler>
    suspend fun getPkmList(userId: String): UtilsResult<List<String>, ErrorHandler>
    suspend fun getSecondFilterList(userId: String): UtilsResult<List<String>, ErrorHandler>
}
