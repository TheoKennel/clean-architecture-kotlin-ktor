package domain.use_cases.custom_dex.save

import domain.error.ErrorHandler
import utils.UtilsResult

fun interface SaveOrUpdateCustomDexName {
    suspend operator fun invoke(userId: String, name: String): UtilsResult<Unit, ErrorHandler>
}

internal class SaveOrUpdateCustomDexNameImpl(
    private val customDexRepository: CustomDexRepository,
) : SaveOrUpdateCustomDexName {

    fun interface CustomDexRepository {

        suspend fun saveName(userId: String,  name: String): UtilsResult<Unit, ErrorHandler>
    }

    override suspend fun invoke(userId: String,  name: String): UtilsResult<Unit, ErrorHandler> = customDexRepository.saveName(userId, name)
}