package presenter.controller.shiny_catch

import domain.models.ShinyCatch
import domain.use_cases.shiny_catch.DeleteShiny
import domain.use_cases.shiny_catch.GetShiny
import domain.use_cases.shiny_catch.SaveOrUpdateShiny
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import presenter.controller.handleErrors
import utils.Result
import javax.inject.Inject

class ShinyImpl @Inject constructor(
    private val deleteShiny: DeleteShiny,
    private val getShinyDomain: GetShiny,
    private val saveOrUpdateShiny: SaveOrUpdateShiny,
) : Shiny {

    override suspend fun deleteShiny(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        when (val result = deleteShiny(userId)) {
            is Result.Success -> call.respond(result.value)
            is Result.Error -> handleErrors(call, result.value)
        }
    }

    override suspend fun getShiny(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        when (val result = getShinyDomain(userId)) {
            is Result.Success -> call.respond(result.value)
            is Result.Error -> handleErrors(call, result.value)
        }
    }

    override suspend fun saveShiny(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        val shinyList = call.receive<List<ShinyCatch>>()
        when (val result = saveOrUpdateShiny(userId, shinyList)) {
            is Result.Success -> call.respond(result.value)
            is Result.Error -> handleErrors(call, result.value)
        }
    }
}