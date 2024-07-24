package domain.use_cases.custom_dex.save

import domain.error.ErrorHandler
import utils.UtilsResult

fun interface SaveOrUpdatePkmList {
    suspend operator fun invoke(userId: String, pkm: List<String>): UtilsResult<Unit, ErrorHandler>
}

internal class SaveOrUpdatePkmListImpl : SaveOrUpdatePkmList {

    override suspend fun invoke(userId: String,  pkm: List<String>): UtilsResult<Unit, ErrorHandler>  {
        return SaveOrUpdateUtils.updateCustomDex(userId) {
            it.pkmList = pkm
        }
    }
}