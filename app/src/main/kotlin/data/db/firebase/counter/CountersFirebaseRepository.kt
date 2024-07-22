package data.db.firebase.counter

import data.db.firebase.FirebaseRepository
import domain.error.ErrorHandler
import domain.models.Counter
import utils.UtilsResult

interface CountersFirebaseRepository {
    suspend fun get(userId: String) : UtilsResult<Counter, ErrorHandler>
    suspend fun save(userId: String, counter:  List<String>) : UtilsResult<Unit, ErrorHandler>
}