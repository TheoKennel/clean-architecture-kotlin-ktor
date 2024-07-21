package presenter.controller.user

import domain.models.User
import domain.use_cases.user.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import presenter.controller.handleErrors
import utils.Result
import javax.inject.Inject

class UserImpl @Inject constructor(
    private val deleteUserById: DeleteUserById,
    private val getAllUsers: GetAllUsers,
    private val getUserById: GetUserById,
    private val saveUser: SaveUser,
    private val updateUserById: UpdateUserById,
) : UserController {

    override suspend fun deleteUser(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        when (val result = deleteUserById(userId)) {
            is Result.Success -> call.respond(result.value)
            is Result.Error -> handleErrors(call, result.value)
        }
    }

    override suspend fun getUsers(call: ApplicationCall) {
        when (val result = getAllUsers()) {
            is Result.Success -> call.respond(result.value)
            is Result.Error -> handleErrors(call, result.value)
        }
    }

    override suspend fun getUserById(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        when (val result = getUserById(userId)) {
            is Result.Success -> call.respond(result.value)
            is Result.Error -> handleErrors(call, result.value)
        }
    }

    override suspend fun save(call: ApplicationCall) {
        val user = call.receive<User>()
        when (val result = saveUser(user)) {
            is Result.Success -> call.respond(result.value)
            is Result.Error -> handleErrors(call, result.value)
        }
    }

    override suspend fun update(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return call.respond(HttpStatusCode.BadRequest)
        val user = call.receive<User>()
        when (val result = updateUserById(userId, user)) {
            is Result.Success -> call.respond(result.value)
            is Result.Error -> handleErrors(call, result.value)
        }
    }
}