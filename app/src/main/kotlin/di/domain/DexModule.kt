package di.domain

import dagger.Module
import dagger.Provides
import data.domain_impl_repository.DexRepositoryImpl
import domain.use_cases.dex.GetDex
import domain.use_cases.dex.GetDexImpl
import domain.use_cases.dex.SaveOrUpdateMainDex
import domain.use_cases.dex.SaveOrUpdateMainDexImpl
import javax.inject.Singleton

@Module
internal class DexModule {

    @Provides
    @Singleton
    fun provideGetDex(
        repository: DexRepositoryImpl
    ) : GetDex {
        return GetDexImpl(repository)
    }

    @Provides
    @Singleton
    fun provideSaveMainDex(
        repository: DexRepositoryImpl
    ) : SaveOrUpdateMainDex {
        return SaveOrUpdateMainDexImpl(repository)
    }
}