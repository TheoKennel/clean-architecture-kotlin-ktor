package domain.use_cases.custom_dex.save

import domain.error.ErrorHandler
import utils.UtilsResult

fun interface SaveOrUpdateSecondFilterList {
    suspend operator fun invoke(userId: String, filter: List<String>): UtilsResult<Unit, ErrorHandler>
}

internal class SaveOrUpdateSecondFilterListImpl(
    private val customDexRepository: CustomDexRepository,
) : SaveOrUpdateSecondFilterList {

    fun interface CustomDexRepository {

        suspend fun saveSecondFilterList(userId: String,   filter: List<String>): UtilsResult<Unit, ErrorHandler>
    }

    override suspend fun invoke(userId: String,  filter: List<String>): UtilsResult<Unit, ErrorHandler> = customDexRepository.saveSecondFilterList(userId, filter)
}