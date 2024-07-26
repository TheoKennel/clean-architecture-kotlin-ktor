package domain.use_cases.custom_dex.get

fun interface GetPkmList {
    suspend operator fun invoke(userId: String, dexName: String): List<String>
}

internal class GetPkmListImpl(
    private val get: GetCustomDexByName,
) : GetPkmList {

    override suspend fun invoke(userId: String, dexName: String): List<String> {
        val result = get.invoke(userId, dexName)
        return result.pkm_list
    }
}