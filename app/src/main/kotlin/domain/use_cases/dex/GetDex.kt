package domain.use_cases.dex

import domain.error.ErrorHandler
import domain.models.Dex
import utils.UtilsResult

fun interface GetDex {
    suspend operator fun invoke(userId: String): UtilsResult<Dex, ErrorHandler>
}

internal class GetDexImpl(
    private val dexRepository: DexRepository,
) : GetDex {

    fun interface DexRepository {

        suspend fun get(userId: String): UtilsResult<Dex, ErrorHandler>
    }

    override suspend fun invoke(userId: String): UtilsResult<Dex, ErrorHandler> = dexRepository.get(userId)
}