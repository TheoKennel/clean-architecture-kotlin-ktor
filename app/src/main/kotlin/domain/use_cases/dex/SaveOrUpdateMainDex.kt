package domain.use_cases.dex

import domain.models.Dex

fun interface SaveOrUpdateMainDex {
    suspend operator fun invoke(userId: String, mainDexCatch: List<String>)
}

internal class SaveOrUpdateMainDexImpl(
    private val dexRepository: DexRepository,
    private val getDex: GetDex,
) : SaveOrUpdateMainDex {

    fun interface DexRepository {

        suspend fun save(userId: String, dex: Dex)
    }

    override suspend fun invoke(userId: String, mainDexCatch: List<String>) {
        val dex = getDex.invoke(userId)
        dex.main_dex_catch = mainDexCatch
        dexRepository.save(userId, dex)
    }
}