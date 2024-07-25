package data.db.db_repository

import domain.models.CustomDex

interface CustomDexRepository {
    suspend fun getCustomDex(userId: String): CustomDex
    suspend fun saveOrUpdateCustomDex(userId: String, customDex: CustomDex)
}