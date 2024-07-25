package data.domain_impl_repository

import data.db.factory.RepositoryFactoryProvider
import domain.models.User
import domain.use_cases.user.*
import utils.Constants

internal class UserRepositoryImpl :
    DeleteUserByIdImpl.UserRepository,
    GetAllUserImpl.UserRepository,
    GetUserByIdImpl.UserRepository,
    SaveUserImpl.UserRepository,
    UpdateUserByIdImpl.UserRepository
{

    private val repositoryFactory = RepositoryFactoryProvider.getFactory(Constants.DATABASE)
    private val repository = repositoryFactory.createUserRepository()

    override suspend fun deleteUserById(userId: String) = repository.delete(userId)

    override suspend fun getAll() : List<User> = repository.getAll()

    override suspend fun getUserById(userId: String): User = repository.get(userId)

    override suspend fun save(user: User) = repository.save(user)

    override suspend fun updateUser(userId: String, user: User) = repository.update(userId, user)
}