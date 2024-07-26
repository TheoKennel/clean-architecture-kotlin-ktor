package domain.use_cases.custom_dex.save

import domain.use_cases.custom_dex.get.GetCustomDexByName

fun interface SaveOrUpdateFirstFilterName {
    suspend operator fun invoke(userId: String, dexName: String, name: String)
}

internal class SaveOrUpdateFirstFilterNameImpl(
    private val getCustomDex: GetCustomDexByName,
    private val saveCustomDex: SaveOrUpdateCustomDex
) : SaveOrUpdateFirstFilterName {

    override suspend fun invoke(userId: String, dexName: String,  name: String) {
        return SaveOrUpdateUtils(getCustomDex, saveCustomDex).updateCustomDex(userId, dexName) {
            it.first_filter_name = name
        }
    }
}