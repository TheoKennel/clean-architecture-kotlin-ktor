package domain.use_cases.dex

import domain.error.ErrorHandler
import domain.models.Dex
import utils.Result
import utils.UtilsResult

fun interface SaveOrUpdateMainDex {
    suspend operator fun invoke(userId: String, mainDexCatch: List<String>): UtilsResult<Unit, ErrorHandler>
}

internal class SaveOrUpdateMainDexImpl(
    private val dexRepository: DexRepository,
    private val getDex: GetDex,
) : SaveOrUpdateMainDex {

    fun interface DexRepository {

        suspend fun save(userId: String, dex: Dex): UtilsResult<Unit, ErrorHandler>
    }

    override suspend fun invoke(userId: String, mainDexCatch: List<String>): UtilsResult<Unit, ErrorHandler> {
        return when ( val result = getDex.invoke(userId)) {
            is Result.Success -> {
                val dex = result.value
                dex.mainDexCatch = mainDexCatch
                dexRepository.save(userId, dex)
            }

            is Result.Error -> Result.Error(result.error ?: ErrorHandler.UnknownError("Unknown error"))
        }
    }
}