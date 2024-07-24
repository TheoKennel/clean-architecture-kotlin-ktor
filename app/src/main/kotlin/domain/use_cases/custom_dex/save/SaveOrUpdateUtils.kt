package domain.use_cases.custom_dex.save

import domain.error.ErrorHandler
import domain.models.CustomDex
import domain.use_cases.custom_dex.get.GetCustomDex
import utils.Result
import utils.UtilsResult

object SaveOrUpdateUtils {

    private lateinit var getCustomDex: GetCustomDex
    private lateinit var save: SaveOrUpdateCustomDex
    suspend fun updateCustomDex(userId: String, updateAction: (customDex: CustomDex) -> Unit): UtilsResult<Unit, ErrorHandler> {
        return when (val result = getCustomDex.invoke(userId)) {
            is Result.Success -> {
                val customDex = result.value
                updateAction(customDex)
                save.invoke(userId, customDex)
            }
            is Result.Error -> Result.Error(result.error ?: ErrorHandler.UnknownError("Unknown Error"))
        }
    }
}