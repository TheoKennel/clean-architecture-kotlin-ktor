package data.db.db_repository

import domain.models.User

interface UserRepository  {
    suspend fun get(userId: String): User
    suspend fun save(user: User)
    suspend fun getAll() : List<User>
    suspend fun delete(userId: String)
    suspend fun update(userId: String, user: User)
}