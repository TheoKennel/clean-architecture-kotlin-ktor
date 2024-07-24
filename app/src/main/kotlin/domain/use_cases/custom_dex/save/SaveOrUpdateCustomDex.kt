package domain.use_cases.custom_dex.save

import domain.error.ErrorHandler
import domain.models.CustomDex
import utils.Result
import utils.UtilsResult

fun interface SaveOrUpdateCustomDex {
    suspend operator fun invoke(userId: String, customDex: CustomDex) : UtilsResult<Unit, ErrorHandler>
}

internal class SaveOrUpdateCustomDexImpl(
    private val repository: SaveOrUpdateCustomDexRepository
) : SaveOrUpdateCustomDex {

    fun interface SaveOrUpdateCustomDexRepository {
        suspend fun save(userId: String, customDex: CustomDex) : UtilsResult <Unit, ErrorHandler>
    }
        override suspend fun invoke(userId: String, customDex: CustomDex): UtilsResult<Unit, ErrorHandler> = repository.save(userId, customDex)
}