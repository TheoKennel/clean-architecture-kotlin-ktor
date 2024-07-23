package data.db.firebase

import data.db.db_repository.CountersRepository
import domain.error.ErrorHandler
import domain.models.Counter
import utils.UtilsResult

internal class FirebaseCounterRepoImpl : CountersRepository {

    override suspend fun get(userId: String): UtilsResult<Counter, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun save(userId: String, counter: List<String>): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }
}