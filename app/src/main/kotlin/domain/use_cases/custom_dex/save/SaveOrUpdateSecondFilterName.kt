package domain.use_cases.custom_dex.save

import domain.error.ErrorHandler
import utils.UtilsResult

fun interface SaveOrUpdateSecondFilterName {
    suspend operator fun invoke(userId: String, name: String): UtilsResult<Unit, ErrorHandler>
}

internal class SaveOrUpdateSecondFilterNameImpl : SaveOrUpdateSecondFilterName {

    override suspend fun invoke(userId: String,  name: String): UtilsResult<Unit, ErrorHandler> {
        return SaveOrUpdateUtils.updateCustomDex(userId) {
            it.secondFilterName = name
        }
    }
}