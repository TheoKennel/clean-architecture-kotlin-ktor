package data.firebase.custom_dex

import utils.UtilsResult
import domain.error.ErrorHandler

interface CustomGetFirebaseRepository {
    suspend fun getCustomDex(userId: String): UtilsResult<List<String>, ErrorHandler>
    suspend fun getFirstFilterList(userId: String): UtilsResult<List<String>, ErrorHandler>
    suspend fun getPkmCatch(userId: String): UtilsResult<List<String>, ErrorHandler>
    suspend fun getPkmList(userId: String): UtilsResult<List<String>, ErrorHandler>
    suspend fun getSecondFilterList(userId: String): UtilsResult<List<String>, ErrorHandler>
}
