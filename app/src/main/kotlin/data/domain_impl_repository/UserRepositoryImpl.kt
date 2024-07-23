package data.domain_impl_repository

import data.db.factory.RepositoryFactoryProvider
import data.db.handleOperationWithErrorCode
import domain.error.ErrorHandler
import domain.models.User
import domain.use_cases.user.*
import utils.Constants
import utils.UtilsResult

internal class UserRepositoryImpl :
    DeleteUserByIdImpl.UserRepository,
    GetAllUserImpl.UserRepository,
    GetUserByIdImpl.UserRepository,
    SaveUserImpl.UserRepository,
    UpdateUserByIdImpl.UserRepository
{

    private val repositoryFactory = RepositoryFactoryProvider.getFactory(Constants.DATABASE)
    private val repository = repositoryFactory.createUserRepository()

    override suspend fun deleteUserById(userId: String): UtilsResult<Unit, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.delete(userId)
        }
    }

    override suspend fun getAll(): UtilsResult<List<User>, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.getAll()
        }
    }

    override suspend fun getUserById(userId: String): UtilsResult<User, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.get(userId)
        }
    }

    override suspend fun save(user: User): UtilsResult<Unit, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.save(user)
        }
    }

    override suspend fun updateUser(userId: String, user: User): UtilsResult<Unit, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.update(userId, user)
        }
    }
}