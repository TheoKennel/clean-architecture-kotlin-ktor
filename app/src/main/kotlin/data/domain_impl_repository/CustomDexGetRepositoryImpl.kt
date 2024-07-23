package data.domain_impl_repository

import data.db.factory.RepositoryFactoryProvider
import data.db.handleOperationWithErrorCode
import domain.error.ErrorHandler
import domain.models.CustomDex
import domain.use_cases.custom_dex.get.*
import utils.Constants
import utils.UtilsResult

internal class CustomDexGetRepositoryImpl :
    GetCustomDexImpl.CustomDexRepository,
    GetFirstFilterListImpl.CustomDexRepository,
    GetPkmCatchImpl.CustomDexRepository,
    GetPkmListImpl.CustomDexRepository,
    GetSecondFilterListImpl.CustomDexRepository
{
    private val repositoryFactory = RepositoryFactoryProvider.getFactory(Constants.DATABASE)
    private val repository = repositoryFactory.createCustomGetRepository()
    override suspend fun get(userId: String): UtilsResult<CustomDex, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.getCustomDex(userId)
        }
    }

    override suspend fun getFirstFilter(userId: String): UtilsResult<List<String>, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.getFirstFilterList(userId)
        }
    }

    override suspend fun getPkmCatch(userId: String): UtilsResult<List<String>, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.getPkmCatch(userId)
        }
    }

    override suspend fun getPkmList(userId: String): UtilsResult<List<String>, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.getPkmList(userId)
        }
    }

    override suspend fun getSecondFilterList(userId: String): UtilsResult<List<String>, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.getSecondFilterList(userId)
        }
    }
}