package di.domain

import dagger.Module
import dagger.Provides
import data.domain_impl_repository.UserRepositoryImpl
import domain.use_cases.user.*
import domain.use_cases.user.DeleteUserByIdImpl
import domain.use_cases.user.GetAllUserImpl
import javax.inject.Singleton

@Module
internal class UserModule {

    @Provides
    @Singleton
    fun provideDeleteUserById(
        repository: UserRepositoryImpl
    ) : DeleteUserById {
        return DeleteUserByIdImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetAllUser(
        repository: UserRepositoryImpl
    ) : GetAllUsers {
        return GetAllUserImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetUserById(
        repository: UserRepositoryImpl
    ) : GetUserById {
        return GetUserByIdImpl(repository)
    }

    @Provides
    @Singleton
    fun provideSaveUser(
        repository: UserRepositoryImpl
    ) : SaveUser {
        return SaveUserImpl(repository)
    }

    @Provides
    @Singleton
    fun provideUpdateUserById(
        repository: UserRepositoryImpl
    ) : UpdateUserById {
        return UpdateUserByIdImpl(repository)
    }
}