package domain.use_cases.custom_dex.save

import domain.error.ErrorHandler
import utils.UtilsResult

fun interface SaveOrUpdateSecondFilterName {
    suspend operator fun invoke(userId: String, name: String): UtilsResult<Unit, ErrorHandler>
}

internal class SaveOrUpdateSecondFilterNameImpl(
    private val customDexRepository: CustomDexRepository,
) : SaveOrUpdateSecondFilterName {

    fun interface CustomDexRepository {

        suspend fun saveSecondFilterName(userId: String,  name: String): UtilsResult<Unit, ErrorHandler>
    }

    override suspend fun invoke(userId: String,  name: String): UtilsResult<Unit, ErrorHandler> = customDexRepository.saveSecondFilterName(userId, name)
}