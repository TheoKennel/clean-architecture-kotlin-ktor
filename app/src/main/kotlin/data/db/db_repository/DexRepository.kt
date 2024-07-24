package data.db.db_repository

import domain.models.Dex

interface DexRepository {
    suspend fun get(userId : String) : Dex
    suspend fun saveOrUpdate(userId: String, dex: Dex)
}