package domain.use_cases.user

import domain.models.User

fun interface GetUserById {
    suspend operator fun invoke(userId: String): User
}

internal class GetUserByIdImpl(
    private val userRepository: UserRepository,
) : GetUserById {
fun interface UserRepository {
        suspend fun getUserById(userId: String): User
    }

    override suspend fun invoke(userId: String): User = userRepository.getUserById(userId)
}