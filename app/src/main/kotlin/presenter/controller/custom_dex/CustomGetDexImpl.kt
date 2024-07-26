package presenter.controller.custom_dex

import domain.use_cases.custom_dex.get.*
import io.ktor.server.application.*
import presenter.controller.handleRequest
import utils.Constants
import javax.inject.Inject

class CustomGetDexImpl @Inject constructor(
    private val getCustomDex: GetCustomDex,
    private val getFirstFilterList: GetFirstFilterList,
    private val getPkmCatch: GetPkmCatch,
    private val getPkmList: GetPkmList,
    private val getSecondFilterList: GetSecondFilterList,
    private val getCustomDexByName: GetCustomDexByName
) : CustomDex {

    override suspend fun getCustomDex(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            getCustomDex(userId)
        }
    }

    override suspend fun getCustomDexByName(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val dexByName = call.parameters["name"] ?: throw IllegalArgumentException(Constants.DEX_NAME_MISSING)
            getCustomDexByName(userId, dexByName)
        }
    }

    override suspend fun getFirstFilterList(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val dexByName = call.parameters["name"] ?: throw IllegalArgumentException(Constants.DEX_NAME_MISSING)
            getFirstFilterList(userId, dexByName)
        }
    }

    override suspend fun getPkmCatch(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val dexByName = call.parameters["name"] ?: throw IllegalArgumentException(Constants.DEX_NAME_MISSING)
            getPkmCatch(userId, dexByName)
        }
    }

    override suspend fun getPkmList(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val dexByName = call.parameters["name"] ?: throw IllegalArgumentException(Constants.DEX_NAME_MISSING)
            getPkmList(userId, dexByName)
        }
    }

    override suspend fun getSecondFilterList(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val dexByName = call.parameters["name"] ?: throw IllegalArgumentException(Constants.DEX_NAME_MISSING)
            getSecondFilterList(userId, dexByName)
        }
    }
}
