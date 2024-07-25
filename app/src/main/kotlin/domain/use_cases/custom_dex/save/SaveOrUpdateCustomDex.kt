package domain.use_cases.custom_dex.save

import domain.models.CustomDex

fun interface SaveOrUpdateCustomDex {
    suspend operator fun invoke(userId: String, customDex: CustomDex)
}

internal class SaveOrUpdateCustomDexImpl(
    private val repository: SaveOrUpdateCustomDexRepository
) : SaveOrUpdateCustomDex {

    fun interface SaveOrUpdateCustomDexRepository {
        suspend fun save(userId: String, customDex: CustomDex)
    }
        override suspend fun invoke(userId: String, customDex: CustomDex) = repository.save(userId, customDex)
}