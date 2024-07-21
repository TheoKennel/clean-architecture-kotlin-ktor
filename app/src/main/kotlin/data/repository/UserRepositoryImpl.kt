package data.repository

import domain.error.ErrorHandler
import domain.models.User
import domain.use_cases.user.*
import domain.use_cases.user.DeleteUserByIdImpl
import domain.use_cases.user.GetAllUserImpl
import domain.use_cases.user.GetUserByIdImpl
import domain.use_cases.user.SaveUserImpl
import utils.UtilsResult

internal class UserRepositoryImpl() :
    DeleteUserByIdImpl.UserRepository,
    GetAllUserImpl.UserRepository,
    GetUserByIdImpl.UserRepository,
    SaveUserImpl.UserRepository,
    UpdateUserByIdImpl.UserRepository
{
    override suspend fun deleteUserById(userId: String): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): UtilsResult<List<User>, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserById(userId: String): UtilsResult<User, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun save(user: User): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(userId: String, user: User): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }
}