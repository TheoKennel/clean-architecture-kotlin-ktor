package domain.use_cases.user

import domain.error.ErrorHandler
import domain.models.User
import utils.UtilsResult

fun interface SaveUser {
    suspend operator fun invoke(user: User) : UtilsResult<Unit, ErrorHandler>
}

internal class SaveUserImpl(
    private val userRepository: UserRepository,
): SaveUser {

    fun interface UserRepository {
        suspend fun save(user: User) : UtilsResult<Unit, ErrorHandler>
    }
    override suspend fun invoke(user: User) = userRepository.save(user)
}