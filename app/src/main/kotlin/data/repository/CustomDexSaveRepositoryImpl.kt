package data.repository

import domain.error.ErrorHandler
import domain.use_cases.custom_dex.save.*
import domain.use_cases.custom_dex.save.SaveOrUpdateCustomDexNameImpl
import domain.use_cases.custom_dex.save.SaveOrUpdateFirstFilterListImpl
import domain.use_cases.custom_dex.save.SaveOrUpdatePkmCatchImpl
import domain.use_cases.custom_dex.save.SaveOrUpdatePkmListImpl
import utils.UtilsResult

internal class CustomDexSaveRepositoryImpl() :
    SaveOrUpdateCustomDexNameImpl.CustomDexRepository,
    SaveOrUpdateFirstFilterListImpl.CustomDexRepository,
    SaveOrUpdatePkmCatchImpl.CustomDexRepository,
    SaveOrUpdatePkmListImpl.CustomDexRepository,
    SaveOrUpdateSecondFilterListImpl.CustomDexRepository,
    SaveOrUpdateSecondFilterNameImpl.CustomDexRepository
{

    override suspend fun saveName(userId: String, name: String): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun saveFirstFilterList(userId: String, filter: List<String>): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun savePkmCatch(userId: String, pkm: List<String>): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun savePkmList(userId: String, pkm: List<String>): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun saveSecondFilterList(userId: String, filter: List<String>): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun saveSecondFilterName(userId: String, name: String): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }
}