package domain.use_cases.custom_dex.save

import domain.models.CustomDex
import domain.use_cases.custom_dex.get.GetCustomDexByName

internal class SaveOrUpdateUtils(
    private val getCustomDex: GetCustomDexByName,
    private val save: SaveOrUpdateCustomDex
){

    suspend fun updateCustomDex(userId: String, dexName: String, updateAction: (customDex: CustomDex) -> Unit) {
                val result = getCustomDex.invoke(userId, dexName)
                updateAction(result)
                save.invoke(userId, dexName, result)
    }
}