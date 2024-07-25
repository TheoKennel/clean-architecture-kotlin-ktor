package domain.use_cases.user

import domain.models.User

fun interface UpdateUserById {
    suspend operator fun invoke(userId: String, user: User)
}

internal class UpdateUserByIdImpl(
    private val userRepository: UserRepository,
): UpdateUserById {

    fun interface UserRepository {
        suspend fun updateUser(userId: String, user: User)
    }

    override suspend fun invoke(userId: String, user: User) = userRepository.updateUser(userId, user)
}
