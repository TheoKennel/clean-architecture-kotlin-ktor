package domain.use_cases.custom_dex.save

import domain.use_cases.custom_dex.get.GetCustomDex

fun interface SaveOrUpdateCustomDexName {
    suspend operator fun invoke(userId: String, name: String)
}

internal class SaveOrUpdateCustomDexNameImpl(
    private val getCustomDex: GetCustomDex,
    private val saveCustomDex: SaveOrUpdateCustomDex
) : SaveOrUpdateCustomDexName {

    override suspend fun invoke(userId: String, name: String) {
        return SaveOrUpdateUtils(getCustomDex, saveCustomDex).updateCustomDex(userId) {
            it.name = name
        }
    }
}