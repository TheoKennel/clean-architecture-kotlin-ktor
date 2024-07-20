package domain.use_cases.user

import domain.error.ErrorHandler
import domain.models.User
import utils.UtilsResult

fun interface GetAllUsers {
    suspend operator fun invoke(): UtilsResult<List<User>, ErrorHandler>
}

internal class GetAllUserImpl(
    private val userRepository: UserRepository,
) : GetAllUsers {

    fun interface UserRepository {
        suspend fun getAll(): UtilsResult<List<User>, ErrorHandler>
    }

    override suspend fun invoke(): UtilsResult<List<User>, ErrorHandler> = userRepository.getAll()
}