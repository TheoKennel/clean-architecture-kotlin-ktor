package domain.use_cases.custom_dex.get

import domain.models.CustomDex

fun interface GetCustomDexByName {
    suspend operator fun invoke(userId: String, dexName: String):  CustomDex
}

internal class GetCustomDexByNameImpl(
    private val customDexRepository: CustomDexRepository,
) : GetCustomDexByName {

    fun interface CustomDexRepository {

        suspend fun get(userId: String, dexName: String):  CustomDex
    }

    override suspend fun invoke(userId: String, dexName: String): CustomDex = customDexRepository.get(userId, dexName)
}