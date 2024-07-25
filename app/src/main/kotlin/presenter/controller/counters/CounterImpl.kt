package presenter.controller.counters

import domain.use_cases.counters.GetCounters
import domain.use_cases.counters.SaveOrUpdateCounters
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import presenter.controller.handleRequest
import utils.Constants
import javax.inject.Inject

typealias ModelCounter = domain.models.Counter

class CounterImpl @Inject constructor(
    private val getCounter: GetCounters,
    private val saveOrUpdateCounters: SaveOrUpdateCounters,
) : Counter {

    override suspend fun getCounter(call: ApplicationCall) {
        handleRequest(call) {
                val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
                getCounter(userId)
        }
    }

    override suspend fun saveOrUpdateCounter(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val counters = call.receive<List<ModelCounter>>()
            saveOrUpdateCounters(userId, counters)
            HttpStatusCode.NoContent
        }
    }
}
