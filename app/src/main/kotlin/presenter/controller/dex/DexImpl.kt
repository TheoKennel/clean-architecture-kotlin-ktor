package presenter.controller.dex

import domain.use_cases.dex.GetDex
import domain.use_cases.dex.SaveOrUpdateMainDex
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import presenter.controller.handleRequest
import javax.inject.Inject

class DexImpl @Inject constructor(
    private val getDex: GetDex,
    private val saveOrUpdateMainDex: SaveOrUpdateMainDex,
) : Dex {

    override suspend fun getDex(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
            getDex(userId)
        }
    }

    override suspend fun saveMainDex(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
            val dex = call.receive<List<String>>()
            saveOrUpdateMainDex(userId, dex)
            HttpStatusCode.NoContent
        }
    }
}