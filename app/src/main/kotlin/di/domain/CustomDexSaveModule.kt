package di.domain

import dagger.Module
import dagger.Provides
import domain.use_cases.custom_dex.save.*
import domain.use_cases.custom_dex.save.SaveOrUpdateCustomDexNameImpl
import domain.use_cases.custom_dex.save.SaveOrUpdateFirstFilterListImpl
import javax.inject.Singleton

@Module
internal class CustomDexSaveModule {

    @Provides
    @Singleton
    fun provideSaveCustomDexName() :  SaveOrUpdateCustomDexName {
        return SaveOrUpdateCustomDexNameImpl()
    }

    @Provides
    @Singleton
    fun provideSaveFirstFilterList(): SaveOrUpdateFirstFilterList {
        return SaveOrUpdateFirstFilterListImpl()
    }

    @Provides
    @Singleton
    fun provideSavePkmCatch() : SaveOrUpdatePkmCatch {
        return SaveOrUpdatePkmCatchImpl()
    }

    @Provides
    @Singleton
    fun provideSavePkmList(): SaveOrUpdatePkmList {
        return SaveOrUpdatePkmListImpl()
    }

    @Provides
    @Singleton
    fun provideSaveSecondFilterList(): SaveOrUpdateSecondFilterList {
        return SaveOrUpdateSecondFilterListImpl()
    }

    @Provides
    @Singleton
    fun provideSaveSecondFilterName() : SaveOrUpdateSecondFilterName {
        return SaveOrUpdateSecondFilterNameImpl()
    }
}