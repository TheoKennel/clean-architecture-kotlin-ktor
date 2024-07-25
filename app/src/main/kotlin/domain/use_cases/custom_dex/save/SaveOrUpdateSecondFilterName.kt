package domain.use_cases.custom_dex.save

import domain.use_cases.custom_dex.get.GetCustomDex

fun interface SaveOrUpdateSecondFilterName {
    suspend operator fun invoke(userId: String, name: String)
}

internal class SaveOrUpdateSecondFilterNameImpl(
    private val getCustomDex: GetCustomDex,
    private val saveCustomDex: SaveOrUpdateCustomDex
) : SaveOrUpdateSecondFilterName {

    override suspend fun invoke(userId: String,  name: String) {
        return SaveOrUpdateUtils(getCustomDex, saveCustomDex).updateCustomDex(userId) {
            it.second_filter_name = name
        }
    }
}