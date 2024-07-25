package data.db.firebase

import data.db.db_repository.UserRepository
import domain.models.User
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

internal class FirebaseUserRepoImpl : UserRepository {

    val repository = FirebaseGenericRepository(User::class.java)

    override suspend fun getAll(): List<User> {
        return suspendCoroutine {
            repository.getAll { result, error ->
                when {
                    error != null -> it.resumeWithException(error)
                    result != null -> it.resume(result)
                    else -> it.resumeWithException(NoSuchElementException("No users found for"))
                }
            }
        }
    }

    override suspend fun get(userId: String): User {
        return suspendCoroutine {
            repository.get(userId) { result, error ->
                when {
                    error != null -> it.resumeWithException(error)
                    result != null -> it.resume(result)
                    else -> it.resumeWithException(NoSuchElementException("No result found for userId: $userId"))
                }
            }
        }
    }

    override suspend fun delete(userId: String) {
        return suspendCoroutine {
            repository.delete(userId) { success, error ->
                when {
                    error != null -> it.resumeWithException(error)
                    success -> it.resume(Unit)
                    else -> it.resumeWithException(NoSuchElementException("Error while deleting user $userId"))
                }
            }
        }
    }

    override suspend fun save(user: User) {
        return suspendCoroutine {
            repository.save(user.id, user) { _, error ->
                when {
                    error != null -> it.resumeWithException(error)
                    else -> it.resume(Unit)
                }
            }
        }
    }

    override suspend fun update(userId: String, user: User) {
        return suspendCoroutine {
            repository.update(userId, user) { _, error ->
                when {
                    error != null -> it.resumeWithException(error)
                    else -> it.resume(Unit)
                }
            }
        }
    }
}
