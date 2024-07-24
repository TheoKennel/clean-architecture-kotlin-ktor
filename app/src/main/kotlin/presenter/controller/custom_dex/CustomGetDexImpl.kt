package presenter.controller.custom_dex

import domain.use_cases.custom_dex.get.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import presenter.controller.handleErrors
import utils.Result
import javax.inject.Inject

class CustomGetDexImpl @Inject constructor(
    private val getCustomDex: GetCustomDex,
    private val getFirstFilterList: GetFirstFilterList,
    private val getPkmCatch: GetPkmCatch,
    private val getPkmList: GetPkmList,
    private val getSecondFilterList: GetSecondFilterList,
) : CustomDex {

    override suspend fun getCustomDex(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        when (val result = getCustomDex(userId)) {
            is Result.Success -> call.respond(result.value)
            is Result.Error -> handleErrors(call, result.value)
        }
    }

    override suspend fun getFirstFilterList(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        when (val result = getFirstFilterList(userId)) {
            is Result.Success -> call.respond(result.value)
            is Result.Error -> handleErrors(call, result.value)
        }
    }

    override suspend fun getPkmCatch(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        when (val result = getPkmCatch(userId)) {
            is Result.Success -> call.respond(result.value)
            is Result.Error -> handleErrors(call, result.value)
        }
    }

    override suspend fun getPkmList(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        when (val result = getPkmList(userId)) {
            is Result.Success -> call.respond(result.value)
            is Result.Error -> handleErrors(call, result.value)
        }
    }

    override suspend fun getSecondFilterList(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        when (val result = getSecondFilterList(userId)) {
            is Result.Success -> call.respond(result.value)
            is Result.Error -> handleErrors(call, result.value)
        }
    }
}