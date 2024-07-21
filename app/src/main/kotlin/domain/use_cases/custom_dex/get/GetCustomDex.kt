package domain.use_cases.custom_dex.get

import domain.error.ErrorHandler
import domain.models.CustomDex
import utils.UtilsResult

fun interface GetCustomDex {
    suspend operator fun invoke(userId: String): UtilsResult<CustomDex, ErrorHandler>
}

internal class GetCustomDexImpl(
    private val customDexRepository: CustomDexRepository,
) : GetCustomDex {

    fun interface CustomDexRepository {

        suspend fun get(userId: String): UtilsResult<CustomDex, ErrorHandler>
    }

    override suspend fun invoke(userId: String): UtilsResult<CustomDex, ErrorHandler> = customDexRepository.get(userId)
}