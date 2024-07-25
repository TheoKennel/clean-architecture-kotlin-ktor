package domain.use_cases.custom_dex.get

fun interface GetPkmList {
    suspend operator fun invoke(userId: String): List<String>
}

internal class GetPkmListImpl(
    private val get: GetCustomDex,
) : GetPkmList {

    override suspend fun invoke(userId: String): List<String> {
        val result = get.invoke(userId)
        return result.pkm_list
    }
}