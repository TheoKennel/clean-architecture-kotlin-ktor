package di

import dagger.Module
import dagger.Provides
import data.domain_impl_repository.*
import data.domain_impl_repository.CustomDexGetRepositoryImpl
import data.domain_impl_repository.CustomDexSaveRepositoryImpl
import data.domain_impl_repository.DexRepositoryImpl
import data.domain_impl_repository.ShinyRepositoryImpl
import data.domain_impl_repository.UserRepositoryImpl
import javax.inject.Singleton

@Module
internal class RepositoryDataModule {

    @Provides
    @Singleton
    fun provideUserRepository(): UserRepositoryImpl {
        return UserRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideShinyRepository(): ShinyRepositoryImpl {
        return ShinyRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideDexRepository(): DexRepositoryImpl {
        return DexRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideCustomDexSaveRepository(): CustomDexSaveRepositoryImpl {
        return CustomDexSaveRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideCustomDexGetRepository(): CustomDexGetRepositoryImpl {
        return CustomDexGetRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideCounterRepository(): CounterRepositoryImpl {
        return CounterRepositoryImpl()
    }
}