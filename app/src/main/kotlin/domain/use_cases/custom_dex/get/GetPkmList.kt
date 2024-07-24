package domain.use_cases.custom_dex.get

import domain.error.ErrorHandler
import utils.Result
import utils.UtilsResult

fun interface GetPkmList {
    suspend operator fun invoke(userId: String): UtilsResult<List<String>, ErrorHandler>
}

internal class GetPkmListImpl(
    private val get: GetCustomDex,
) : GetPkmList {

    override suspend fun invoke(userId: String): UtilsResult<List<String>, ErrorHandler> {
        return when (val result = get.invoke(userId)) {
            is Result.Success -> Result.Success(result.value.pkmList)
            is Result.Error -> Result.Error(result.error ?: ErrorHandler.UnknownError("Unknown Error"))
        }
    }
}