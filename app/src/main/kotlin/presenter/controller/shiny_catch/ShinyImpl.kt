package presenter.controller.shiny_catch

import domain.models.ShinyCatch
import domain.use_cases.shiny_catch.GetShiny
import domain.use_cases.shiny_catch.SaveOrUpdateShiny
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import presenter.controller.handleRequest
import utils.Constants
import javax.inject.Inject

class ShinyImpl @Inject constructor(
    private val getShinyDomain: GetShiny,
    private val saveOrUpdateShiny: SaveOrUpdateShiny,
) : Shiny {

    override suspend fun getShiny(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            getShinyDomain(userId)
        }
    }

    override suspend fun saveShiny(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val shinyList = call.receive<List<ShinyCatch>>()
            saveOrUpdateShiny(userId, shinyList)
            HttpStatusCode.NoContent
        }
    }
}