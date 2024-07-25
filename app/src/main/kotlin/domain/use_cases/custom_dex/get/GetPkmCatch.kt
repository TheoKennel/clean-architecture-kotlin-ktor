package domain.use_cases.custom_dex.get

fun interface GetPkmCatch {
    suspend operator fun invoke(userId: String): List<String>
}

internal class GetPkmCatchImpl(
    private val get: GetCustomDex,
) : GetPkmCatch {

    override suspend fun invoke(userId: String): List<String> {
        val result = get.invoke(userId)
        return result.pkm_catch
    }
}