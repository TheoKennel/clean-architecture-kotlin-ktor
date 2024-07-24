package data.domain_impl_repository

import data.db.factory.RepositoryFactoryProvider
import data.db.handleOperationWithErrorCode
import domain.error.ErrorHandler
import domain.models.ShinyCatch
import domain.use_cases.shiny_catch.GetShinyImpl
import domain.use_cases.shiny_catch.SaveOrUpdateShinyImpl
import utils.Constants
import utils.UtilsResult

internal class ShinyRepositoryImpl :
    GetShinyImpl.ShinyRepository,
    SaveOrUpdateShinyImpl.ShinyRepository {

    private val repositoryFactory = RepositoryFactoryProvider.getFactory(Constants.DATABASE)
    private val repository = repositoryFactory.createShinyRepository()

    override suspend fun get(userId: String): UtilsResult<List<ShinyCatch>, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.get(userId)
        }
    }

    override suspend fun add(userId: String, shinyCatch: List<ShinyCatch>): UtilsResult<Unit, ErrorHandler> {
        return handleOperationWithErrorCode {
            repository.saveOrUpdate(userId, shinyCatch)
        }
    }
}