package presenter.controller.custom_dex

import domain.use_cases.custom_dex.save.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import presenter.controller.handleRequest
import presenter.request.*
import utils.Constants
import javax.inject.Inject

class CustomSaveDexImpl @Inject constructor(
    private val saveOrUpdateCustomDexName: SaveOrUpdateCustomDexName,
    private val saveOrUpdateFirstFilterList: SaveOrUpdateFirstFilterList,
    private val saveOrUpdatePkmCatch: SaveOrUpdatePkmCatch,
    private val saveOrUpdatePkmList: SaveOrUpdatePkmList,
    private val saveOrUpdateSecondFilterList: SaveOrUpdateSecondFilterList,
    private val saveOrUpdateSecondFilterName: SaveOrUpdateSecondFilterName,
    private val saveOrUpdateFirstFilterNameImpl: SaveOrUpdateFirstFilterName
) : CustomSaveDex {

    override suspend fun saveCustomDexName(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val dexByName = call.parameters["name"] ?: throw IllegalArgumentException(Constants.DEX_NAME_MISSING)
            val name = call.receive<UpdateCustomDexNameRequest>()
            saveOrUpdateCustomDexName(userId, dexByName, name.name)
            HttpStatusCode.NoContent
        }
    }

    override suspend fun saveFirstFilterList(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val dexByName = call.parameters["name"] ?: throw IllegalArgumentException(Constants.DEX_NAME_MISSING)
            val filters = call.receive<UpdateCustomDexFirstFilterListRequest>()
            saveOrUpdateFirstFilterList(userId, dexByName, filters.first_filter_list)
            HttpStatusCode.NoContent
        }
    }

    override suspend fun saveFirstFilterListName(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val dexByName = call.parameters["name"] ?: throw IllegalArgumentException(Constants.DEX_NAME_MISSING)
            val filter = call.receive<UpdateCustomDexFirstFilterNameRequest>()
            saveOrUpdateFirstFilterNameImpl(userId, dexByName, filter.first_filter_name)
            HttpStatusCode.NoContent
        }
    }

    override suspend fun savePkmCatch(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val dexByName = call.parameters["name"] ?: throw IllegalArgumentException(Constants.DEX_NAME_MISSING)
            val pkm = call.receive<UpdateCustomDexPkmCatchRequest>()
            saveOrUpdatePkmCatch(userId, dexByName, pkm.pkm_catch)
            HttpStatusCode.NoContent
        }
    }

    override suspend fun savePkmList(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val dexByName = call.parameters["name"] ?: throw IllegalArgumentException(Constants.DEX_NAME_MISSING)
            val pkm = call.receive<UpdateCustomDexPkmListRequest>()
            saveOrUpdatePkmList(userId, dexByName, pkm.pkm_list)
            HttpStatusCode.NoContent
        }
    }

    override suspend fun saveSecondFilterList(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val dexByName = call.parameters["name"] ?: throw IllegalArgumentException(Constants.DEX_NAME_MISSING)
            val filter = call.receive<UpdateCustomDexSecondFilterListRequest>()
            saveOrUpdateSecondFilterList(userId, dexByName, filter.second_filter_list)
            HttpStatusCode.NoContent
        }
    }

    override suspend fun saveSecondFilterName(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val dexByName = call.parameters["name"] ?: throw IllegalArgumentException(Constants.DEX_NAME_MISSING)
            val name = call.receive<UpdateCustomDexSecondFilterListNameRequest>()
            saveOrUpdateSecondFilterName(userId, dexByName, name.second_filter_name)
            HttpStatusCode.NoContent
        }
    }
}
