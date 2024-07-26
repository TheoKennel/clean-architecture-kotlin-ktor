package domain.use_cases.custom_dex.get

fun interface GetSecondFilterList {
    suspend operator fun invoke(userId: String, dexName: String): List<String>
}

internal class GetSecondFilterListImpl(
    private val getCustomDex: GetCustomDexByName
) : GetSecondFilterList {


    override suspend fun invoke(userId: String, dexName: String): List<String> {
        val result = getCustomDex.invoke(userId, dexName)
        return result.second_filter_list
    }
}