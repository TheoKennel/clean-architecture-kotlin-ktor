package data.firebase.user

import data.firebase.FirebaseRepository
import domain.error.ErrorHandler
import domain.models.User
import utils.UtilsResult

interface UserFirebaseRepository  {
    suspend fun get(userId: String): UtilsResult<User, ErrorHandler>
    suspend fun save(user: User): UtilsResult<Unit, ErrorHandler>
    suspend fun getAll() : UtilsResult<List<User>, ErrorHandler>
    suspend fun delete(userId: String) : UtilsResult<Unit, ErrorHandler>
    suspend fun update(userId: String, user: User) : UtilsResult<Unit, ErrorHandler>
}