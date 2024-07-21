package domain.use_cases.user

import domain.error.ErrorHandler
import domain.models.User
import utils.Result
import utils.UtilsResult

fun interface GetUserById {
    suspend operator fun invoke(userId: String): Result<User, ErrorHandler>
}

internal class GetUserByIdImpl(
    private val userRepository: UserRepository,
) : GetUserById {
fun interface UserRepository {
        suspend fun getUserById(userId: String): UtilsResult<User, ErrorHandler>
    }

    override suspend fun invoke(userId: String): UtilsResult<User, ErrorHandler> = userRepository.getUserById(userId)
}