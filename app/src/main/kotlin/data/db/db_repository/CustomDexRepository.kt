package data.db.db_repository

import utils.UtilsResult
import domain.error.ErrorHandler
import domain.models.CustomDex

interface CustomDexRepository {
    suspend fun getCustomDex(userId: String): CustomDex
    suspend fun saveOrUpdateCustomDex(userId: String, customDex: CustomDex)
}