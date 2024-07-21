package data.repository

import data.firebase.shiny_catch.ShinyFirebaseRepository
import data.handleFirebaseOperationWithErrorCode
import domain.error.ErrorHandler
import domain.models.ShinyCatch
import domain.use_cases.shiny_catch.DeleteShinyImpl
import domain.use_cases.shiny_catch.GetShinyImpl
import domain.use_cases.shiny_catch.SaveOrUpdateShinyImpl
import utils.UtilsResult

internal class ShinyRepositoryImpl(private val dbRepository: ShinyFirebaseRepository) :
    DeleteShinyImpl.ShinyRepository,
    GetShinyImpl.ShinyRepository,
    SaveOrUpdateShinyImpl.ShinyRepository {
    override suspend fun delete(userId: String): UtilsResult<Unit, ErrorHandler> {
        return handleFirebaseOperationWithErrorCode {
            dbRepository.delete(userId)
        }
    }

    override suspend fun get(userId: String): UtilsResult<List<ShinyCatch>, ErrorHandler> {
        return handleFirebaseOperationWithErrorCode {
            dbRepository.get(userId)
        }
    }

    override suspend fun add(userId: String, shinyCatch: List<ShinyCatch>): UtilsResult<Unit, ErrorHandler> {
        return handleFirebaseOperationWithErrorCode {
            dbRepository.saveOrUpdate(userId, shinyCatch)
        }
    }
}