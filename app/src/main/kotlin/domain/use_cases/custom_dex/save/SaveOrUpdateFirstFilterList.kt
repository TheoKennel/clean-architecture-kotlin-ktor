package domain.use_cases.custom_dex.save

import domain.error.ErrorHandler
import utils.UtilsResult

fun interface SaveOrUpdateFirstFilterList {
    suspend operator fun invoke(userId: String, filter: List<String>): UtilsResult<Unit, ErrorHandler>
}

internal class SaveOrUpdateFirstFilterListImpl : SaveOrUpdateFirstFilterList {

    override suspend fun invoke(userId: String,  filter: List<String>): UtilsResult<Unit, ErrorHandler> {
        return SaveOrUpdateUtils.updateCustomDex(userId) {
                it.firstFilterList = filter
        }
    }
}