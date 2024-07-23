package di.domain

import dagger.Module
import dagger.Provides
import data.domain_impl_repository.CustomDexSaveRepositoryImpl
import domain.use_cases.custom_dex.save.*
import domain.use_cases.custom_dex.save.SaveOrUpdateCustomDexNameImpl
import domain.use_cases.custom_dex.save.SaveOrUpdateFirstFilterListImpl
import javax.inject.Singleton

@Module
internal class CustomDexSaveModule {

    @Provides
    @Singleton
    fun provideSaveCustomDexName(
        repository : CustomDexSaveRepositoryImpl
    ) : SaveOrUpdateCustomDexName {
        return SaveOrUpdateCustomDexNameImpl(repository)
    }

    @Provides
    @Singleton
    fun provideSaveFirstFilterList(
        repository : CustomDexSaveRepositoryImpl
    ) : SaveOrUpdateFirstFilterList {
        return SaveOrUpdateFirstFilterListImpl(repository)
    }

    @Provides
    @Singleton
    fun provideSavePkmCatch(
        repository : CustomDexSaveRepositoryImpl
    ) : SaveOrUpdatePkmCatch {
        return SaveOrUpdatePkmCatchImpl(repository)
    }

    @Provides
    @Singleton
    fun provideSavePkmList(
        repository : CustomDexSaveRepositoryImpl
    ) : SaveOrUpdatePkmList {
        return SaveOrUpdatePkmListImpl(repository)
    }

    @Provides
    @Singleton
    fun provideSaveSecondFilterList(
        repository : CustomDexSaveRepositoryImpl
    ) : SaveOrUpdateSecondFilterList {
        return SaveOrUpdateSecondFilterListImpl(repository)
    }

    @Provides
    @Singleton
    fun provideSaveSecondFilterName(
        repository : CustomDexSaveRepositoryImpl
    ) : SaveOrUpdateSecondFilterName {
        return SaveOrUpdateSecondFilterNameImpl(repository)
    }
}