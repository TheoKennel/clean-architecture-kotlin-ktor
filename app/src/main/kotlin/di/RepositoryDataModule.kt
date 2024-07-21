package di

import dagger.Module
import dagger.Provides
import data.repository.*
import data.repository.CustomDexGetRepositoryImpl
import data.repository.CustomDexSaveRepositoryImpl
import data.repository.DexRepositoryImpl
import data.repository.ShinyRepositoryImpl
import data.repository.UserRepositoryImpl
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