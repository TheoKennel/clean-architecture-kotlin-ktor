package domain.use_cases.custom_dex.save

import domain.use_cases.custom_dex.get.GetCustomDexByName

fun interface SaveOrUpdateSecondFilterName {
    suspend operator fun invoke(userId: String, dexName: String, name: String)
}

internal class SaveOrUpdateSecondFilterNameImpl(
    private val getCustomDex: GetCustomDexByName,
    private val saveCustomDex: SaveOrUpdateCustomDex
) : SaveOrUpdateSecondFilterName {

    override suspend fun invoke(userId: String, dexName: String,  name: String) {
        return SaveOrUpdateUtils(getCustomDex, saveCustomDex).updateCustomDex(userId, dexName) {
            it.second_filter_name = name
        }
    }
}