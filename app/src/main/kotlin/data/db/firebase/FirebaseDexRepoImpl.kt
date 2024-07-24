package data.db.firebase

import data.db.db_repository.DexRepository
import domain.error.ErrorHandler
import domain.models.Dex
import utils.UtilsResult

internal class FirebaseDexRepoImpl : DexRepository {

    override suspend fun get(userId: String): UtilsResult<Dex, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun saveOrUpdate(userId: String, mainDexCatch: List<String>): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }
}
