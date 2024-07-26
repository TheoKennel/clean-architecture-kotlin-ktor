package data.db.db_repository

import domain.models.CustomDex

interface CustomDexRepository {
    suspend fun getCustomDex(userId: String): List<CustomDex>
    suspend fun saveOrUpdateCustomDex(userId: String, customDex:  CustomDex, dexName: String)
    suspend fun getCustomDexByDexName(userId: String, dexName: String): CustomDex
}