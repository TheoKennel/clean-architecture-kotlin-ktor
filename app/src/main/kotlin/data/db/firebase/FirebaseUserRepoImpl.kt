package data.db.firebase

import data.db.db_repository.UserRepository
import domain.models.User

internal class FirebaseUserRepoImpl : UserRepository {

    override suspend fun getAll(): List<User> {
        TODO("Not yet implemented")
    }

    override suspend fun get(userId: String): User {
        TODO("Not yet implemented")
    }

    override suspend fun delete(userId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun save(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun update(userId: String, user: User) {
        TODO("Not yet implemented")
    }
}
