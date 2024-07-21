package di.domain

import dagger.Module
import dagger.Provides
import data.repository.CustomDexGetRepositoryImpl
import domain.use_cases.custom_dex.get.*
import domain.use_cases.custom_dex.get.GetCustomDexImpl
import domain.use_cases.custom_dex.get.GetFirstFilterListImpl
import domain.use_cases.custom_dex.get.GetPkmCatchImpl
import javax.inject.Singleton

@Module
internal class CustomDexGetModule {

    @Provides
    @Singleton
    fun provideGetCustomDex(
        repository : CustomDexGetRepositoryImpl
    ) : GetCustomDex {
        return GetCustomDexImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetFirstFilterList(
        repository : CustomDexGetRepositoryImpl
    ) : GetFirstFilterList {
        return GetFirstFilterListImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetPkmCatch(
        repository : CustomDexGetRepositoryImpl
    ) : GetPkmCatch {
        return GetPkmCatchImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetPkmList(
        repository : CustomDexGetRepositoryImpl
    ) : GetPkmList {
        return GetPkmListImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetSecondFilterList(
        repository : CustomDexGetRepositoryImpl
    ) : GetSecondFilterList {
        return GetSecondFilterListImpl(repository)
    }
}