package presenter.controller.custom_dex

import io.ktor.server.application.*

interface CustomSaveDex {
    suspend fun saveCustomDexName(call: ApplicationCall)
    suspend fun saveFirstFilterList(call: ApplicationCall)
    suspend fun savePkmCatch(call: ApplicationCall)
    suspend fun savePkmList(call: ApplicationCall)
    suspend fun saveSecondFilterList(call: ApplicationCall)
    suspend fun saveSecondFilterName(call: ApplicationCall)
}