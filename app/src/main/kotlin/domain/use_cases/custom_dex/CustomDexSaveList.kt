package domain.use_cases.custom_dex

import domain.error.ErrorHandler
import utils.UtilsResult

fun interface CustomDexSaveList {
    suspend operator fun invoke(userId : String, List<String>) : UtilsResult<List<String>, ErrorHandler>
}

internal class CustomDexSaveListImpl(
    private val
)