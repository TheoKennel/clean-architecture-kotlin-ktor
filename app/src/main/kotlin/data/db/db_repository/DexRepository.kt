package data.db.db_repository

import domain.error.ErrorHandler
import domain.models.Dex
import utils.UtilsResult

interface DexRepository {
    suspend fun get(userId : String) : UtilsResult<Dex, ErrorHandler>
    suspend fun saveOrUpdate(userId: String, mainDexCatch: List<String>) : UtilsResult<Unit, ErrorHandler>
}