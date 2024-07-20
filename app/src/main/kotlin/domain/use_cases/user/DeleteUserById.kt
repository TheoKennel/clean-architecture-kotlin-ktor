package domain.use_cases.user

fun interface DeleteUserById {
    suspend operator fun invoke(userId: Int)
}

internal class DeleteUserByIdImpl(
    private val userRepository: UserRepository,
) : DeleteUserById {
    fun interface UserRepository {
        suspend fun deleteUserById(userId: Int)
    }

    override suspend fun invoke(userId: Int) = userRepository.deleteUserById(userId)
}