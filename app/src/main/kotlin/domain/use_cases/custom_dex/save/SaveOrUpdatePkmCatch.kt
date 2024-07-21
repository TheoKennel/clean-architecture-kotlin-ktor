package domain.use_cases.custom_dex.save

import domain.error.ErrorHandler
import utils.UtilsResult

fun interface SaveOrUpdatePkmCatch {
    suspend operator fun invoke(userId: String, pkm: List<String>): UtilsResult<Unit, ErrorHandler>
}

internal class SaveOrUpdatePkmCatchImpl(
    private val customDexRepository: CustomDexRepository,
) : SaveOrUpdatePkmCatch {

    fun interface CustomDexRepository {

        suspend fun savePkmCatch(userId: String,   pkm: List<String>): UtilsResult<Unit, ErrorHandler>
    }

    override suspend fun invoke(userId: String,  pkm: List<String>): UtilsResult<Unit, ErrorHandler> = customDexRepository.savePkmCatch(userId, pkm)
}