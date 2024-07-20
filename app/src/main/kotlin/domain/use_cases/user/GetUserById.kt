package domain.use_cases.user

import domain.error.ErrorHandler
import domain.models.User
import utils.Result
import utils.UtilsResult

fun interface GetUserById {
    suspend operator fun invoke(): Result<User, ErrorHandler>
}

internal class GetUserByIdImpl(
    private val userRepository: UserRepository,
) : GetUserById {
fun interface UserRepository {
        suspend fun getUserById(): UtilsResult<User, ErrorHandler>
    }

    override suspend fun invoke(): UtilsResult<User, ErrorHandler> = userRepository.getUserById()
}