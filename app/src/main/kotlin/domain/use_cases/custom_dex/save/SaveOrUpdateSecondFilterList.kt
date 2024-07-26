package domain.use_cases.custom_dex.save

import domain.use_cases.custom_dex.get.GetCustomDexByName

fun interface SaveOrUpdateSecondFilterList {
    suspend operator fun invoke(userId: String, dexName: String, filter: List<String>)
}

internal class SaveOrUpdateSecondFilterListImpl(
    private val getCustomDex: GetCustomDexByName,
    private val saveCustomDex: SaveOrUpdateCustomDex
) : SaveOrUpdateSecondFilterList {

    override suspend fun invoke(userId: String, dexName: String,  filter: List<String>) {
        return SaveOrUpdateUtils(getCustomDex, saveCustomDex).updateCustomDex(userId, dexName) {
            it.second_filter_list = filter
        }
    }
}