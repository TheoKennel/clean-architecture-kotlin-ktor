package data.db.firebase

import data.db.db_repository.DexRepository
import domain.models.Dex

internal class FirebaseDexRepoImpl : DexRepository {

    override suspend fun get(userId: String): Dex {
        TODO("Not yet implemented")
    }

    override suspend fun saveOrUpdate(userId: String, dex: Dex) {
        TODO("Not yet implemented")
    }
}
