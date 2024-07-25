package domain.use_cases.custom_dex.save

import domain.models.CustomDex
import domain.use_cases.custom_dex.get.GetCustomDex

internal class SaveOrUpdateUtils(
    private val getCustomDex: GetCustomDex,
    private val save: SaveOrUpdateCustomDex
){

    suspend fun updateCustomDex(userId: String, updateAction: (customDex: CustomDex) -> Unit) {
                val result = getCustomDex.invoke(userId)
                updateAction(result)
                save.invoke(userId, result)
    }
}