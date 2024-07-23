package data.db.firebase

import data.db.db_repository.CustomSaveRepository
import domain.error.ErrorHandler
import utils.UtilsResult

internal class FirebaseCustomSaveRepoImpl : CustomSaveRepository {

    override suspend fun saveCustomDexName(userId: String, name: String): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun saveFirstFilterList(userId: String, filters: List<String>): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun savePkmCatch(userId: String, pkmCatchList: List<String>): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun savePkmList(userId: String, pkmList: List<String>): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun saveSecondFilterList(userId: String, filters: List<String>): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun saveSecondFilterName(userId: String, name: String): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }
}