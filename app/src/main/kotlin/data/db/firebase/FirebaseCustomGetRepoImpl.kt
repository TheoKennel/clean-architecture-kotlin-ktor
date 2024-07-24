package data.db.firebase

import data.db.db_repository.CustomGetRepository
import domain.error.ErrorHandler
import domain.models.CustomDex
import utils.UtilsResult

internal class FirebaseCustomGetRepoImpl : CustomGetRepository {

    override suspend fun getCustomDex(userId: String): UtilsResult<CustomDex, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun getFirstFilterList(userId: String): UtilsResult<List<String>, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun getPkmCatch(userId: String): UtilsResult<List<String>, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun getPkmList(userId: String): UtilsResult<List<String>, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun getSecondFilterList(userId: String): UtilsResult<List<String>, ErrorHandler> {
        TODO("Not yet implemented")
    }
}
