package domain.use_cases.user

import domain.models.User

fun interface UpdateUserById {
    suspend operator fun invoke(user: User)
}

internal class UpdateUserByIdImpl(
    private val userRepository: UserRepository,
): UpdateUserById {

    fun interface UserRepository {
        suspend fun updateUser(user: User)
    }

    override suspend fun invoke(user: User) = userRepository.updateUser(user)
}
