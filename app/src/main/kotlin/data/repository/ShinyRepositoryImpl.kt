package data.repository

import domain.error.ErrorHandler
import domain.models.ShinyCatch
import domain.use_cases.shiny_catch.DeleteShinyImpl
import domain.use_cases.shiny_catch.GetShinyImpl
import domain.use_cases.shiny_catch.SaveOrUpdateShinyImpl
import utils.UtilsResult

internal class ShinyRepositoryImpl() :
    DeleteShinyImpl.ShinyRepository,
    GetShinyImpl.ShinyRepository,
    SaveOrUpdateShinyImpl.ShinyRepository
{
    override suspend fun delete(userId: String): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun get(userId: String): UtilsResult<List<ShinyCatch>, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun add(userId: String, shinyCatch: List<ShinyCatch>): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }
}