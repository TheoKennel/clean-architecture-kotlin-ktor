package data.db.firebase

import data.db.db_repository.ShinyRepository
import domain.models.ShinyCatch

internal class FirebaseShinyRepoImpl : ShinyRepository {

    override suspend fun get(userId: String): List<ShinyCatch> {
        TODO("Not yet implemented")
    }

    override suspend fun saveOrUpdate(userId: String, shinyCatch: List<ShinyCatch>) {
        TODO("Not yet implemented")
    }
}
