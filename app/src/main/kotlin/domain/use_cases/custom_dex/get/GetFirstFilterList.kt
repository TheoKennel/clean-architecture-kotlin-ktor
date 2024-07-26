package domain.use_cases.custom_dex.get

fun interface GetFirstFilterList {
    suspend operator fun invoke(userId: String, dexName: String): List<String>
}

internal class GetFirstFilterListImpl(
    private val get: GetCustomDexByName,
) : GetFirstFilterList {

    override suspend fun invoke(userId: String, dexName: String): List<String> {
            val result = get.invoke(userId, dexName)
            return result.first_filter_list
    }
}