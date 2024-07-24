package domain.use_cases.custom_dex.get

import domain.error.ErrorHandler
import utils.Result
import utils.UtilsResult

fun interface GetPkmCatch {
    suspend operator fun invoke(userId: String): UtilsResult<List<String>, ErrorHandler>
}

internal class GetPkmCatchImpl(
    private val get: GetCustomDex,
) : GetPkmCatch {

    override suspend fun invoke(userId: String): UtilsResult<List<String>, ErrorHandler> {
        return when (val result = get.invoke(userId)) {
            is Result.Success -> Result.Success(result.value.pkmCatch)
            is Result.Error -> Result.Error(result.error ?: ErrorHandler.UnknownError("Unknown Error"))
        }
    }
}