package domain.use_cases.custom_dex.get

import domain.error.ErrorHandler
import utils.UtilsResult

fun interface GetPkmList {
    suspend operator fun invoke(userId: String): UtilsResult<List<String>, ErrorHandler>
}

internal class GetPkmListImpl(
    private val customDexRepository: CustomDexRepository,
) : GetPkmList {

    fun interface CustomDexRepository {

        suspend fun getPkmList(userId: String): UtilsResult<List<String>, ErrorHandler>
    }

    override suspend fun invoke(userId: String): UtilsResult<List<String>, ErrorHandler> = customDexRepository.getPkmList(userId)
}