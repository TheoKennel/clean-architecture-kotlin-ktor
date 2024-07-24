package data.db.firebase

import data.db.db_repository.CustomDexRepository
import domain.models.CustomDex

internal class FirebaseCustomDexRepoImpl : CustomDexRepository {

    override suspend fun getCustomDex(userId: String): CustomDex {
        TODO("Not yet implemented")
    }

    override suspend fun saveOrUpdateCustomDex(userId: String, customDex: CustomDex) {
        TODO("Not yet implemented")
    }
}