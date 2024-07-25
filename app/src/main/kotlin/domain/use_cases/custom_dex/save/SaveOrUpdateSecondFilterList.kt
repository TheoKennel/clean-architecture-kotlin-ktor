package domain.use_cases.custom_dex.save

import domain.use_cases.custom_dex.get.GetCustomDex

fun interface SaveOrUpdateSecondFilterList {
    suspend operator fun invoke(userId: String, filter: List<String>)
}

internal class SaveOrUpdateSecondFilterListImpl(
    private val getCustomDex: GetCustomDex,
    private val saveCustomDex: SaveOrUpdateCustomDex
) : SaveOrUpdateSecondFilterList {

    override suspend fun invoke(userId: String,  filter: List<String>) {
        return SaveOrUpdateUtils(getCustomDex, saveCustomDex).updateCustomDex(userId) {
            it.second_filter_list = filter
        }
    }
}