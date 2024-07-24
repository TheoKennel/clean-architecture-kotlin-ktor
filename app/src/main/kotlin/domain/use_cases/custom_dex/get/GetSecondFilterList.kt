package domain.use_cases.custom_dex.get

import domain.error.ErrorHandler
import utils.Result
import utils.UtilsResult

fun interface GetSecondFilterList {
    suspend operator fun invoke(userId: String): UtilsResult<List<String>, ErrorHandler>
}

internal class GetSecondFilterListImpl(
    private val getCustomDex: GetCustomDex
) : GetSecondFilterList {


    override suspend fun invoke(userId: String): UtilsResult<List<String>, ErrorHandler> {
        return when (val result = getCustomDex(userId)) {
            is Result.Success -> Result.Success(result.value.secondFilterList)
            is Result.Error -> Result.Error(result.error ?: throw Exception("Unknown Error"))
        }
    }
}