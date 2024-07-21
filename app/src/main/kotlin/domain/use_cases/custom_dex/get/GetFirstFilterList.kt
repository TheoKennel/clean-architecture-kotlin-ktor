package domain.use_cases.custom_dex.get

import domain.error.ErrorHandler
import utils.UtilsResult

fun interface GetFirstFilterList {
    suspend operator fun invoke(userId: String): UtilsResult<List<String>, ErrorHandler>
}

internal class GetFirstFilterListImpl(
    private val customDexRepository: CustomDexRepository,
) : GetFirstFilterList {

    fun interface CustomDexRepository {

        suspend fun getFirstFilter(userId: String): UtilsResult<List<String>, ErrorHandler>
    }

    override suspend fun invoke(userId: String): UtilsResult<List<String>, ErrorHandler> = customDexRepository.getFirstFilter(userId)
}