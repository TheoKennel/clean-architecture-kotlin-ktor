package domain.use_cases.custom_dex.save

import domain.use_cases.custom_dex.get.GetCustomDexByName

fun interface SaveOrUpdateFirstFilterList {
    suspend operator fun invoke(userId: String, dexName: String, filter: List<String>)
}

internal class SaveOrUpdateFirstFilterListImpl(
    private val getCustomDex: GetCustomDexByName,
    private val saveCustomDex: SaveOrUpdateCustomDex
) : SaveOrUpdateFirstFilterList {

    override suspend fun invoke(userId: String, dexName: String,  filter: List<String>) {
        return SaveOrUpdateUtils(getCustomDex, saveCustomDex).updateCustomDex(userId, dexName) {
                it.first_filter_list = filter
        }
    }
}