package presenter.controller.counters

import domain.use_cases.counters.GetCounters
import domain.use_cases.counters.SaveOrUpdateCounters
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import presenter.controller.handleErrors
import utils.Result
import javax.inject.Inject

class CounterImpl @Inject constructor(
    private val getCounter: GetCounters,
    private val saveOrUpdateCounters: SaveOrUpdateCounters,
) : Counter {

    override suspend fun getCounter(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        when (val result = getCounter(userId)) {
            is Result.Success -> call.respond(result.value)
            is Result.Error -> handleErrors(call, result.value)
        }
    }

    override suspend fun saveOrUpdateCounter(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        val counters = call.receive<List<String>>()
        when (val result = saveOrUpdateCounters(userId, counters)) {
            is Result.Success -> call.respond(result.value)
            is Result.Error -> handleErrors(call, result.value)
        }
    }
}