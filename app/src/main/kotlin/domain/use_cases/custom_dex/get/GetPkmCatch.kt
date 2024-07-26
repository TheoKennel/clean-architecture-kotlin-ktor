package domain.use_cases.custom_dex.get

fun interface GetPkmCatch {
    suspend operator fun invoke(userId: String, dexName: String): List<String>
}

internal class GetPkmCatchImpl(
    private val get: GetCustomDexByName,
) : GetPkmCatch {

    override suspend fun invoke(userId: String, dexName: String): List<String> {
        val result = get.invoke(userId, dexName)
        return result.pkm_catch
    }
}