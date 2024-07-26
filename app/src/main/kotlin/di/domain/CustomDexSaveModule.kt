package di.domain

import dagger.Module
import dagger.Provides
import data.domain_impl_repository.CustomDexRepositoryImpl
import domain.use_cases.custom_dex.get.GetCustomDexByName
import domain.use_cases.custom_dex.save.*
import javax.inject.Provider
import javax.inject.Singleton

@Module
internal class CustomDexSaveModule {

    @Provides
    fun provideSaveOrUpdateCustomDex(
        repository: CustomDexRepositoryImpl
    ): SaveOrUpdateCustomDex {
        return SaveOrUpdateCustomDexImpl(repository)
    }

    @Provides
    @Singleton
    fun provideSaveCustomDexName(
        getCustomDex: Provider<GetCustomDexByName>,
        saveOrUpdateCustomDex: Provider<SaveOrUpdateCustomDex>
    ): SaveOrUpdateCustomDexName {
        return SaveOrUpdateCustomDexNameImpl(getCustomDex.get(), saveOrUpdateCustomDex.get())
    }

    @Provides
    @Singleton
    fun provideSaveFirstFilterList(
        getCustomDex: Provider<GetCustomDexByName>,
        saveOrUpdateCustomDex: Provider<SaveOrUpdateCustomDex>
    ): SaveOrUpdateFirstFilterList {
        return SaveOrUpdateFirstFilterListImpl(getCustomDex.get(), saveOrUpdateCustomDex.get())
    }

    @Provides
    @Singleton
    fun provideSaveFirstFilterName(
        getCustomDex: Provider<GetCustomDexByName>,
        saveOrUpdateCustomDex: Provider<SaveOrUpdateCustomDex>
    ): SaveOrUpdateFirstFilterName {
        return SaveOrUpdateFirstFilterNameImpl(getCustomDex.get(), saveOrUpdateCustomDex.get())
    }

    @Provides
    @Singleton
    fun provideSavePkmCatch(
        getCustomDex: Provider<GetCustomDexByName>,
        saveOrUpdateCustomDex: Provider<SaveOrUpdateCustomDex>
    ): SaveOrUpdatePkmCatch {
        return SaveOrUpdatePkmCatchImpl(getCustomDex.get(), saveOrUpdateCustomDex.get())
    }

    @Provides
    @Singleton
    fun provideSavePkmList(
        getCustomDex: Provider<GetCustomDexByName>,
        saveOrUpdateCustomDex: Provider<SaveOrUpdateCustomDex>
    ): SaveOrUpdatePkmList {
        return SaveOrUpdatePkmListImpl(getCustomDex.get(), saveOrUpdateCustomDex.get())
    }

    @Provides
    @Singleton
    fun provideSaveSecondFilterList(
        getCustomDex: Provider<GetCustomDexByName>,
        saveOrUpdateCustomDex: Provider<SaveOrUpdateCustomDex>
    ): SaveOrUpdateSecondFilterList {
        return SaveOrUpdateSecondFilterListImpl(getCustomDex.get(), saveOrUpdateCustomDex.get())
    }

    @Provides
    @Singleton
    fun provideSaveSecondFilterName(
        getCustomDex: Provider<GetCustomDexByName>,
        saveOrUpdateCustomDex: Provider<SaveOrUpdateCustomDex>
    ): SaveOrUpdateSecondFilterName {
        return SaveOrUpdateSecondFilterNameImpl(getCustomDex.get(), saveOrUpdateCustomDex.get())
    }
}