package domain.use_cases.user

import domain.error.ErrorHandler
import domain.models.User
import utils.UtilsResult

fun interface UpdateUserById {
    suspend operator fun invoke(userId: String, user: User) : UtilsResult<Unit, ErrorHandler>
}

internal class UpdateUserByIdImpl(
    private val userRepository: UserRepository,
): UpdateUserById {

    fun interface UserRepository {
        suspend fun updateUser(userId: String, user: User) : UtilsResult<Unit, ErrorHandler>
    }

    override suspend fun invoke(userId: String, user: User) = userRepository.updateUser(userId, user)
}
