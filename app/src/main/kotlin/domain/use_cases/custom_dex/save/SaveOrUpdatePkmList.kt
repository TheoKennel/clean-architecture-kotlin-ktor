package domain.use_cases.custom_dex.save

import domain.use_cases.custom_dex.get.GetCustomDexByName

fun interface SaveOrUpdatePkmList {
    suspend operator fun invoke(userId: String, dexName: String, pkm: List<String>)
}

internal class SaveOrUpdatePkmListImpl(
    private val getCustomDex: GetCustomDexByName,
    private val saveCustomDex: SaveOrUpdateCustomDex
) : SaveOrUpdatePkmList {

    override suspend fun invoke(userId: String, dexName: String,  pkm: List<String>)  {
        return SaveOrUpdateUtils(getCustomDex, saveCustomDex).updateCustomDex(userId, dexName) {
            it.pkm_list = pkm
        }
    }
}