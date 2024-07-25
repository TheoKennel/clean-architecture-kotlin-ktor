package presenter.controller.custom_dex

import domain.use_cases.custom_dex.save.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import presenter.controller.handleRequest
import utils.Constants
import javax.inject.Inject

class CustomSaveDexImpl @Inject constructor(
    private val saveOrUpdateCustomDexName: SaveOrUpdateCustomDexName,
    private val saveOrUpdateFirstFilterList: SaveOrUpdateFirstFilterList,
    private val saveOrUpdatePkmCatch: SaveOrUpdatePkmCatch,
    private val saveOrUpdatePkmList: SaveOrUpdatePkmList,
    private val saveOrUpdateSecondFilterList: SaveOrUpdateSecondFilterList,
    private val saveOrUpdateSecondFilterName: SaveOrUpdateSecondFilterName
) : CustomSaveDex {

    override suspend fun saveCustomDexName(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val name = call.receive<String>()
            saveOrUpdateCustomDexName(userId, name)
            HttpStatusCode.NoContent
        }
    }

    override suspend fun saveFirstFilterList(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val filters = call.receive<List<String>>()
            saveOrUpdateFirstFilterList(userId, filters)
            HttpStatusCode.NoContent
        }
    }

    override suspend fun savePkmCatch(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val pkm = call.receive<List<String>>()
            saveOrUpdatePkmCatch(userId, pkm)
            HttpStatusCode.NoContent
        }
    }

    override suspend fun savePkmList(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val pkm = call.receive<List<String>>()
            saveOrUpdatePkmList(userId, pkm)
            HttpStatusCode.NoContent
        }
    }

    override suspend fun saveSecondFilterList(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val filter = call.receive<List<String>>()
            saveOrUpdateSecondFilterList(userId, filter)
            HttpStatusCode.NoContent
        }
    }

    override suspend fun saveSecondFilterName(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val name = call.receive<String>()
            saveOrUpdateSecondFilterName(userId, name)
            HttpStatusCode.NoContent
        }
    }
}
