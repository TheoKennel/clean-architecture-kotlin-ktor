package data.db.firebase

import data.db.db_repository.UserRepository
import domain.error.ErrorHandler
import domain.models.User
import utils.UtilsResult

internal class FirebaseUserRepoImpl : UserRepository {

    override suspend fun getAll(): UtilsResult<List<User>, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(userId: String): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun get(userId: String): UtilsResult<User, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun save(user: User): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun update(userId: String, user: User): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }
}
