package presenter.controller.dex

import io.ktor.server.application.*

interface Dex {
    suspend fun getDex(call: ApplicationCall)
    suspend fun saveMainDex(call: ApplicationCall)
}