package domain.use_cases.custom_dex.get

import domain.error.ErrorHandler
import utils.UtilsResult

fun interface GetSecondFilterList {
    suspend operator fun invoke(userId: String): UtilsResult<List<String>, ErrorHandler>
}

internal class GetSecondFilterListImpl(
    private val customDexRepository: CustomDexRepository,
) : GetSecondFilterList {

    fun interface CustomDexRepository {

        suspend fun getSecondFilterList(userId: String): UtilsResult<List<String>, ErrorHandler>
    }

    override suspend fun invoke(userId: String): UtilsResult<List<String>, ErrorHandler> = customDexRepository.getSecondFilterList(userId)
}