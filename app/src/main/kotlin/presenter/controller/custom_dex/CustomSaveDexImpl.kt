package presenter.controller.custom_dex

import domain.use_cases.custom_dex.save.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import presenter.controller.handleErrors
import utils.Result

class CustomSaveDexImpl(
    private val saveOrUpdateCustomDexName: SaveOrUpdateCustomDexName,
    private val saveOrUpdateFirstFilterList: SaveOrUpdateFirstFilterList,
    private val saveOrUpdatePkmCatch: SaveOrUpdatePkmCatch,
    private val saveOrUpdatePkmList: SaveOrUpdatePkmList,
    private val saveOrUpdateSecondFilterList: SaveOrUpdateSecondFilterList,
    private val saveOrUpdateSecondFilterName: SaveOrUpdateSecondFilterName
) : CustomSaveDex {

    override suspend fun saveCustomDexName(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        val name = call.receive<String>()
        when (val result = saveOrUpdateCustomDexName(userId, name)) {
            is Result.Success -> call.respond(HttpStatusCode.NoContent)
            is Result.Error -> handleErrors(call, result.value)
        }
    }

    override suspend fun saveFirstFilterList(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        val filters = call.receive<List<String>>()
        when (val result = saveOrUpdateFirstFilterList(userId, filters)) {
            is Result.Success -> call.respond(HttpStatusCode.NoContent)
            is Result.Error -> handleErrors(call, result.value)
        }
    }

    override suspend fun savePkmCatch(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        val pkm = call.receive<List<String>>()
        when (val result = saveOrUpdatePkmCatch(userId, pkm)) {
            is Result.Success -> call.respond(HttpStatusCode.NoContent)
            is Result.Error -> handleErrors(call, result.value)
        }
    }

    override suspend fun savePkmList(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        val pkm = call.receive<List<String>>()
        when (val result = saveOrUpdatePkmList(userId, pkm)) {
            is Result.Success -> call.respond(HttpStatusCode.NoContent)
            is Result.Error -> handleErrors(call, result.value)
        }
    }

    override suspend fun saveSecondFilterList(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        val filter = call.receive<List<String>>()
        when (val result = saveOrUpdateSecondFilterList(userId, filter)) {
            is Result.Success -> call.respond(HttpStatusCode.NoContent)
            is Result.Error -> handleErrors(call, result.value)
        }
    }

    override suspend fun saveSecondFilterName(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        val name = call.receive<String>()
        when (val result = saveOrUpdateSecondFilterName(userId, name)) {
            is Result.Success -> call.respond(HttpStatusCode.NoContent)
            is Result.Error -> handleErrors(call, result.value)
        }
    }
}