package presenter.controller.dex

import domain.use_cases.dex.GetDex
import domain.use_cases.dex.SaveOrUpdateMainDex
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import presenter.controller.handleErrors
import utils.Result

class DexImpl(
    private val getDex: GetDex,
    private val saveOrUpdateMainDex: SaveOrUpdateMainDex,
) : Dex {

    override suspend fun getDex(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        when (val result = getDex(userId)) {
            is Result.Success -> call.respond(result.value)
            is Result.Error -> handleErrors(call, result.value)
        }
    }

    override suspend fun saveMainDex(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        val dex = call.receive<List<String>>()
        when (val result = saveOrUpdateMainDex(userId, dex)) {
            is Result.Success -> call.respond(result.value)
            is Result.Error -> handleErrors(call, result.value)
        }
    }
}