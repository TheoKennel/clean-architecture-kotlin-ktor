package presenter.controller.counters

import io.ktor.server.application.*

interface Counter {
    suspend fun getCounter(call : ApplicationCall)
    suspend fun saveOrUpdateCounter(call: ApplicationCall)
}