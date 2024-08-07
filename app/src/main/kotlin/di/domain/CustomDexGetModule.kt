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
    fun provideGetCustomDexByName(
        repository: CustomDexRepositoryImpl
    ) : GetCustomDexByName {
        return GetCustomDexByNameImpl(repository)
    }

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
        getCustomDex: GetCustomDexByName
    ) : GetFirstFilterList {
        return GetFirstFilterListImpl(getCustomDex)
    }

    @Provides
    @Singleton
    fun provideGetPkmCatch(
        getCustomDex: GetCustomDexByName
    ) : GetPkmCatch {
        return GetPkmCatchImpl(getCustomDex)
    }

    @Provides
    @Singleton
    fun provideGetPkmList(
        getCustomDex: GetCustomDexByName
    ) : GetPkmList {
        return GetPkmListImpl(getCustomDex)
    }

    @Provides
    @Singleton
    fun provideGetSecondFilterList(
        getCustomDex: GetCustomDexByName
    ) : GetSecondFilterList {
        return GetSecondFilterListImpl(getCustomDex)
    }
}