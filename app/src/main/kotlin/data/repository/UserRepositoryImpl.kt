package data.repository

import data.db.firebase.user.UserFirebaseRepository
import data.db.firebase.handleFirebaseOperationWithErrorCode
import domain.error.ErrorHandler
import domain.models.User
import domain.use_cases.user.*
import domain.use_cases.user.DeleteUserByIdImpl
import domain.use_cases.user.GetAllUserImpl
import domain.use_cases.user.GetUserByIdImpl
import domain.use_cases.user.SaveUserImpl
import utils.UtilsResult

internal class UserRepositoryImpl(private val dbRepository: UserFirebaseRepository) :
    DeleteUserByIdImpl.UserRepository,
    GetAllUserImpl.UserRepository,
    GetUserByIdImpl.UserRepository,
    SaveUserImpl.UserRepository,
    UpdateUserByIdImpl.UserRepository
{
    override suspend fun deleteUserById(userId: String): UtilsResult<Unit, ErrorHandler> {
        return handleFirebaseOperationWithErrorCode {
            dbRepository.delete(userId)
        }
    }

    override suspend fun getAll(): UtilsResult<List<User>, ErrorHandler> {
        return handleFirebaseOperationWithErrorCode {
            dbRepository.getAll()
        }
    }

    override suspend fun getUserById(userId: String): UtilsResult<User, ErrorHandler> {
        return handleFirebaseOperationWithErrorCode {
            dbRepository.get(userId)
        }
    }

    override suspend fun save(user: User): UtilsResult<Unit, ErrorHandler> {
        return handleFirebaseOperationWithErrorCode {
            dbRepository.save(user)
        }
    }

    override suspend fun updateUser(userId: String, user: User): UtilsResult<Unit, ErrorHandler> {
        return handleFirebaseOperationWithErrorCode {
            dbRepository.update(userId, user)
        }
    }
}