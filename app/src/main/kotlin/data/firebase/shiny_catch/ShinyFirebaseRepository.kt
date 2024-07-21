package data.firebase.shiny_catch

import data.firebase.FirebaseRepository
import domain.error.ErrorHandler
import domain.models.ShinyCatch
import utils.UtilsResult

interface ShinyFirebaseRepository {
    suspend fun get(userId: String): UtilsResult<List<ShinyCatch>, ErrorHandler>
    suspend fun saveOrUpdate(userId: String, shinyCatch:  List<ShinyCatch>): UtilsResult<Unit, ErrorHandler>
    suspend fun delete(userId: String): UtilsResult<Unit, ErrorHandler>
}