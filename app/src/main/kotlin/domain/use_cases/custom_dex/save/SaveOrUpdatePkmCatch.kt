package domain.use_cases.custom_dex.save

import domain.use_cases.custom_dex.get.GetCustomDex

fun interface SaveOrUpdatePkmCatch {
    suspend operator fun invoke(userId: String, pkm: List<String>)
}

internal class SaveOrUpdatePkmCatchImpl(
    private val getCustomDex: GetCustomDex,
    private val saveCustomDex: SaveOrUpdateCustomDex
) : SaveOrUpdatePkmCatch {


    override suspend fun invoke(userId: String,  pkm: List<String>) {
        return SaveOrUpdateUtils(getCustomDex, saveCustomDex).updateCustomDex(userId) {
            it.pkm_catch = pkm
        }
    }
}