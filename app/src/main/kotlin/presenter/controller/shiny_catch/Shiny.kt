package presenter.controller.shiny_catch

import io.ktor.server.application.*

interface Shiny {
    suspend fun getShiny(call: ApplicationCall)
    suspend fun saveShiny(call: ApplicationCall)
}