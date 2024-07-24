package di

import dagger.Module
import dagger.Provides
import data.domain_impl_repository.*
import data.domain_impl_repository.CustomDexRepositoryImpl
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
    fun provideCustomDexRepository(): CustomDexRepositoryImpl {
        return CustomDexRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideCounterRepository(): CounterRepositoryImpl {
        return CounterRepositoryImpl()
    }
}