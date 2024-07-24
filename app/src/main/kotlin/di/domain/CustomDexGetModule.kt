package di.domain

import dagger.Module
import dagger.Provides
import data.domain_impl_repository.CustomDexRepositoryImpl
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
        repository : CustomDexRepositoryImpl
    ) : GetCustomDex {
        return GetCustomDexImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetFirstFilterList(
        repository : CustomDexRepositoryImpl
    ) : GetFirstFilterList {
        return GetFirstFilterListImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetPkmCatch(
        repository : CustomDexRepositoryImpl
    ) : GetPkmCatch {
        return GetPkmCatchImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetPkmList(
        repository : CustomDexRepositoryImpl
    ) : GetPkmList {
        return GetPkmListImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetSecondFilterList(
        repository : CustomDexRepositoryImpl
    ) : GetSecondFilterList {
        return GetSecondFilterListImpl(repository)
    }
}