package data.db.db_repository

import domain.models.ShinyCatch

interface ShinyRepository {
    suspend fun get(userId: String): List<ShinyCatch>
    suspend fun saveOrUpdate(userId: String, shinyCatch:  List<ShinyCatch>)
}