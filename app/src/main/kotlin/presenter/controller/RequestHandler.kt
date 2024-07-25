package presenter.controller

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

suspend inline fun  handleRequest(call: ApplicationCall, operation: () -> Any?) {
    try {
        val result = operation()
        if (result != null) {
            call.respond(result)
        } else {
            call.respond(HttpStatusCode.NoContent)
        }
    } catch (e: IllegalArgumentException) {
        call.respond(HttpStatusCode.BadRequest, e.message ?: "Invalid argument")
    } catch (e: Exception) {
        call.respond(HttpStatusCode.InternalServerError, e.message ?: "Internal server error")
    }
}
