package domain.use_cases.custom_dex.save

import domain.error.ErrorHandler
import utils.UtilsResult

fun interface SaveOrUpdateFirstFilterList {
    suspend operator fun invoke(userId: String, filter: List<String>): UtilsResult<Unit, ErrorHandler>
}

internal class SaveOrUpdateFirstFilterListImpl(
    private val customDexRepository: CustomDexRepository,
) : SaveOrUpdateFirstFilterList {

    fun interface CustomDexRepository {

        suspend fun saveFirstFilterList(userId: String,   filter: List<String>): UtilsResult<Unit, ErrorHandler>
    }

    override suspend fun invoke(userId: String,  filter: List<String>): UtilsResult<Unit, ErrorHandler> = customDexRepository.saveFirstFilterList(userId, filter)
}