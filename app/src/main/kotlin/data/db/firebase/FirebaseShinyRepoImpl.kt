package data.db.firebase

import data.db.db_repository.ShinyRepository
import domain.error.ErrorHandler
import domain.models.ShinyCatch
import utils.UtilsResult

internal class FirebaseShinyRepoImpl : ShinyRepository {

    override suspend fun get(userId: String): UtilsResult<List<ShinyCatch>, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(userId: String): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun saveOrUpdate(userId: String, shinyCatch: List<ShinyCatch>): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }
}
