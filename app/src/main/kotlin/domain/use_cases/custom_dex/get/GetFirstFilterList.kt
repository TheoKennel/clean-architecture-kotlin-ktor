package domain.use_cases.custom_dex.get

fun interface GetFirstFilterList {
    suspend operator fun invoke(userId: String): List<String>
}

internal class GetFirstFilterListImpl(
    private val get: GetCustomDex,
) : GetFirstFilterList {

    override suspend fun invoke(userId: String): List<String> {
            val result = get.invoke(userId)
        println("result in first filter = $result")
        println("result first filter list = ${result.first_filter_list}")
            return result.first_filter_list
    }
}