package data.db.db_repository

import domain.error.ErrorHandler
import domain.models.ShinyCatch
import utils.UtilsResult

interface ShinyRepository {
    suspend fun get(userId: String): List<ShinyCatch>
    suspend fun saveOrUpdate(userId: String, shinyCatch:  List<ShinyCatch>)
}