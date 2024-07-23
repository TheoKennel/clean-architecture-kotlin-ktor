package data.domain_impl_repository

import data.db.factory.RepositoryFactoryProvider
import data.db.handleOperationWithErrorCode
import domain.error.ErrorHandler
import domain.use_cases.custom_dex.save.*
import domain.use_cases.custom_dex.save.SaveOrUpdateCustomDexNameImpl
import domain.use_cases.custom_dex.save.SaveOrUpdateFirstFilterListImpl
import domain.use_cases.custom_dex.save.SaveOrUpdatePkmCatchImpl
import domain.use_cases.custom_dex.save.SaveOrUpdatePkmListImpl
import utils.Constants
import utils.UtilsResult

internal class CustomDexSaveRepositoryImpl() :
    SaveOrUpdateCustomDexNameImpl.CustomDexRepository,
    SaveOrUpdateFirstFilterListImpl.CustomDexRepository,
    SaveOrUpdatePkmCatchImpl.CustomDexRepository,
    SaveOrUpdatePkmListImpl.CustomDexRepository,
    SaveOrUpdateSecondFilterListImpl.CustomDexRepository,
    SaveOrUpdateSecondFilterNameImpl.CustomDexRepository
{

    private val repositoryFactory = RepositoryFactoryProvider.getFactory(Constants.DATABASE)
    private val repository = repositoryFactory.createCustomSaveRepository()

    override suspend fun saveName(userId: String, name: String): UtilsResult<Unit, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.saveCustomDexName(userId, name)
        }
    }

    override suspend fun saveFirstFilterList(userId: String, filter: List<String>): UtilsResult<Unit, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.saveFirstFilterList(userId, filter)
        }    }

    override suspend fun savePkmCatch(userId: String, pkm: List<String>): UtilsResult<Unit, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.savePkmCatch(userId, pkm)
        }
    }

    override suspend fun savePkmList(userId: String, pkm: List<String>): UtilsResult<Unit, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.savePkmList(userId, pkm)
        }
    }

    override suspend fun saveSecondFilterList(userId: String, filter: List<String>): UtilsResult<Unit, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.saveSecondFilterList(userId, filter)
        }
    }

    override suspend fun saveSecondFilterName(userId: String, name: String): UtilsResult<Unit, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.saveSecondFilterName(userId, name)
        }
    }
}