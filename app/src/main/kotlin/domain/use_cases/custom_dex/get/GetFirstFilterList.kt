package domain.use_cases.custom_dex.get

import domain.error.ErrorHandler
import utils.Result
import utils.UtilsResult

fun interface GetFirstFilterList {
    suspend operator fun invoke(userId: String): UtilsResult<List<String>, ErrorHandler>
}

internal class GetFirstFilterListImpl(
    private val get: GetCustomDex,
) : GetFirstFilterList {

    override suspend fun invoke(userId: String): UtilsResult<List<String>, ErrorHandler> {
        return when (val result = get.invoke(userId)) {
            is Result.Success -> Result.Success(result.value.firstFilterList)
            is Result.Error -> Result.Error(result.error ?: ErrorHandler.UnknownError("Unknown Error"))
        }
    }
}