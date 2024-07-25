package domain.use_cases.custom_dex.get

import domain.models.CustomDex

fun interface GetCustomDex {
    suspend operator fun invoke(userId: String): CustomDex
}

internal class GetCustomDexImpl(
    private val customDexRepository: CustomDexRepository,
) : GetCustomDex {

    fun interface CustomDexRepository {

        suspend fun get(userId: String): CustomDex
    }

    override suspend fun invoke(userId: String): CustomDex = customDexRepository.get(userId)
}