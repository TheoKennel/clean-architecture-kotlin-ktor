package data.db.db_repository

import domain.error.ErrorHandler
import domain.models.Counter
import utils.UtilsResult

interface CountersRepository {
    suspend fun get(userId: String) : UtilsResult<Counter, ErrorHandler>
    suspend fun save(userId: String, counter:  List<String>) : UtilsResult<Unit, ErrorHandler>
}