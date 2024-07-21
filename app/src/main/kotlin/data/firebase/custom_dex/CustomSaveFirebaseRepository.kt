package data.firebase.custom_dex

import utils.UtilsResult
import domain.error.ErrorHandler

interface CustomSaveFirebaseRepository {
    suspend fun saveCustomDexName(userId: String, name: String): UtilsResult<Unit, ErrorHandler>
    suspend fun saveFirstFilterList(userId: String, filters: List<String>): UtilsResult<Unit, ErrorHandler>
    suspend fun savePkmCatch(userId: String, pkmCatchList: List<String>): UtilsResult<Unit, ErrorHandler>
    suspend fun savePkmList(userId: String, pkmList: List<String>): UtilsResult<Unit, ErrorHandler>
    suspend fun saveSecondFilterList(userId: String, filters: List<String>): UtilsResult<Unit, ErrorHandler>
    suspend fun saveSecondFilterName(userId: String, name: String): UtilsResult<Unit, ErrorHandler>
}