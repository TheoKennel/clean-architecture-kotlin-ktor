package data.domain_impl_repository

import data.db.factory.RepositoryFactoryProvider
import data.db.handleOperationWithErrorCode
import domain.error.ErrorHandler
import domain.models.Dex
import domain.use_cases.dex.GetDexImpl
import domain.use_cases.dex.SaveOrUpdateMainDexImpl
import utils.Constants
import utils.UtilsResult

internal class DexRepositoryImpl :
    GetDexImpl.DexRepository,
    SaveOrUpdateMainDexImpl.DexRepository
{
    private val repositoryFactory = RepositoryFactoryProvider.getFactory(Constants.DATABASE)
    private val repository = repositoryFactory.createDexRepository()

    override suspend fun get(userId: String): UtilsResult<Dex, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.get(userId)
        }
    }

    override suspend fun save(userId: String, dex: Dex): UtilsResult<Unit, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.saveOrUpdate(userId, dex)
        }
    }
}