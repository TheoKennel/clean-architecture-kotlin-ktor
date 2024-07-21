package presenter.controller.custom_dex

import io.ktor.server.application.*

interface CustomGetDex {
    suspend fun getCustomDex(call: ApplicationCall)
    suspend fun getFirstFilterList(call: ApplicationCall)
    suspend fun getPkmCatch(call: ApplicationCall)
    suspend fun getPkmList(call: ApplicationCall)
    suspend fun getSecondFilterList(call: ApplicationCall)
}