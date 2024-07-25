package domain.use_cases.user

fun interface DeleteUserById {
    suspend operator fun invoke(userId: String)
}

internal class DeleteUserByIdImpl(
    private val userRepository: UserRepository,
) : DeleteUserById {
    fun interface UserRepository {
        suspend fun deleteUserById(userId: String)
    }

    override suspend fun invoke(userId: String) = userRepository.deleteUserById(userId)
}