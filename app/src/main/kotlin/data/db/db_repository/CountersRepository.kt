package data.db.db_repository

import domain.error.ErrorHandler
import domain.models.Counter
import utils.UtilsResult

interface CountersRepository {
    suspend fun get(userId: String) : Counter
    suspend fun save(userId: String, counter:  List<String>) : Unit
}