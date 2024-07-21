package domain.use_cases.dex

import domain.error.ErrorHandler
import utils.UtilsResult

fun interface SaveOrUpdateMainDex {
    suspend operator fun invoke(userId: String, mainDexCatch: List<String>): UtilsResult<Unit, ErrorHandler>
}

internal class SaveOrUpdateMainDexImpl(
    private val dexRepository: DexRepository,
) : SaveOrUpdateMainDex {

    fun interface DexRepository {

        suspend fun save(userId: String, mainDexCatch: List<String>): UtilsResult<Unit, ErrorHandler>
    }

    override suspend fun invoke(userId: String, mainDexCatch: List<String>): UtilsResult<Unit, ErrorHandler> =
        dexRepository.save(userId, mainDexCatch)
}