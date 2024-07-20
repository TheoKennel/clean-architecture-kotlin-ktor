package domain.use_cases.user

import domain.models.User

fun interface SaveUser {
    suspend operator fun invoke(user: User)
}

internal class SaveUserImpl(
    private val userRepository: UserRepository,
): SaveUser {

    fun interface UserRepository {
        suspend fun save(user: User)
    }
    override suspend fun invoke(user: User) = userRepository.save(user)
}