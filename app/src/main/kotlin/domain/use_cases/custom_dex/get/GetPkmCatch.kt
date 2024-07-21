package domain.use_cases.custom_dex.get

import domain.error.ErrorHandler
import utils.UtilsResult

fun interface GetPkmCatch {
    suspend operator fun invoke(userId: String): UtilsResult<List<String>, ErrorHandler>
}

internal class GetPkmCatchImpl(
    private val customDexRepository: CustomDexRepository,
) : GetPkmCatch {

    fun interface CustomDexRepository {

        suspend fun getPkmCatch(userId: String): UtilsResult<List<String>, ErrorHandler>
    }

    override suspend fun invoke(userId: String): UtilsResult<List<String>, ErrorHandler> = customDexRepository.getPkmCatch(userId)
}