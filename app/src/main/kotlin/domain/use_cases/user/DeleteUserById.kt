package domain.use_cases.user

import domain.error.ErrorHandler
import utils.UtilsResult

fun interface DeleteUserById {
    suspend operator fun invoke(userId: String): UtilsResult<Unit, ErrorHandler>
}

internal class DeleteUserByIdImpl(
    private val userRepository: UserRepository,
) : DeleteUserById {
    fun interface UserRepository {
        suspend fun deleteUserById(userId: String) : UtilsResult<Unit, ErrorHandler>
    }

    override suspend fun invoke(userId: String) = userRepository.deleteUserById(userId)
}