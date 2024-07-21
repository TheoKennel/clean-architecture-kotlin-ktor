package presenter.controller

import domain.error.ErrorHandler
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

suspend fun handleErrors(call: ApplicationCall, error: ErrorHandler) {
    when (error) {
        is ErrorHandler.ServerError -> call.respond(HttpStatusCode.fromValue(error.code), error)
        is ErrorHandler.ClientError -> call.respond(HttpStatusCode.fromValue(error.code), error)
        is ErrorHandler.UnknownError -> call.respond(HttpStatusCode.InternalServerError, error )
        ErrorHandler.NetworkError -> call.respond(HttpStatusCode.ServiceUnavailable, error)
    }
}

const val INVALID_DATA_RESPONSE =  "Invalid request data"