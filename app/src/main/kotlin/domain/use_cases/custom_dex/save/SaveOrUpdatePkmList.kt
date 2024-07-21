package domain.use_cases.custom_dex.save

import domain.error.ErrorHandler
import utils.UtilsResult

fun interface SaveOrUpdatePkmList {
    suspend operator fun invoke(userId: String, pkm: List<String>): UtilsResult<Unit, ErrorHandler>
}

internal class SaveOrUpdatePkmListImpl(
    private val customDexRepository: CustomDexRepository,
) : SaveOrUpdatePkmList {

    fun interface CustomDexRepository {

        suspend fun savePkmList(userId: String, pkm: List<String>): UtilsResult<Unit, ErrorHandler>
    }

    override suspend fun invoke(userId: String,  pkm: List<String>): UtilsResult<Unit, ErrorHandler> = customDexRepository.savePkmList(userId, pkm)
}