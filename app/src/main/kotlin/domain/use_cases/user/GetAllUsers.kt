package domain.use_cases.user

import domain.models.User

fun interface GetAllUsers {
    suspend operator fun invoke(): List<User>
}

internal class GetAllUserImpl(
    private val userRepository: UserRepository,
) : GetAllUsers {

    fun interface UserRepository {
        suspend fun getAll(): List<User>
    }

    override suspend fun invoke(): List<User> = userRepository.getAll()
}