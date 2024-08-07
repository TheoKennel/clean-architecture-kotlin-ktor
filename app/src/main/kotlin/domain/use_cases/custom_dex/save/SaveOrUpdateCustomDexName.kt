package domain.use_cases.custom_dex.save

import domain.use_cases.custom_dex.get.GetCustomDexByName

fun interface SaveOrUpdateCustomDexName {
    suspend operator fun invoke(userId: String, dexName: String, name: String)
}

internal class SaveOrUpdateCustomDexNameImpl(
    private val getCustomDex: GetCustomDexByName,
    private val saveCustomDex: SaveOrUpdateCustomDex
) : SaveOrUpdateCustomDexName {

    override suspend fun invoke(userId: String, dexName: String, name: String) {
        return SaveOrUpdateUtils(getCustomDex, saveCustomDex).updateCustomDex(userId, dexName) {
            it.name = name
        }
    }
}