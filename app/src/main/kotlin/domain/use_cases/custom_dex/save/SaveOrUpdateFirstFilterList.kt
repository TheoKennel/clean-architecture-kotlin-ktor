package domain.use_cases.custom_dex.save

import domain.use_cases.custom_dex.get.GetCustomDex

fun interface SaveOrUpdateFirstFilterList {
    suspend operator fun invoke(userId: String, filter: List<String>)
}

internal class SaveOrUpdateFirstFilterListImpl(
    private val getCustomDex: GetCustomDex,
    private val saveCustomDex: SaveOrUpdateCustomDex
) : SaveOrUpdateFirstFilterList {

    override suspend fun invoke(userId: String,  filter: List<String>) {
        return SaveOrUpdateUtils(getCustomDex, saveCustomDex).updateCustomDex(userId) {
                it.first_filter_list = filter
        }
    }
}