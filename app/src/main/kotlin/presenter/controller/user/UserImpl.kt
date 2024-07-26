package presenter.controller.user

import domain.models.User
import domain.use_cases.user.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import presenter.controller.handleRequest
import utils.Constants
import javax.inject.Inject

class UserImpl @Inject constructor(
    private val deleteUserById: DeleteUserById,
    private val getAllUsers: GetAllUsers,
    private val getUserById: GetUserById,
    private val saveUser: SaveUser,
    private val updateUserById: UpdateUserById,
) : UserController {

    override suspend fun deleteUser(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            deleteUserById(userId)
            HttpStatusCode.NoContent
        }
    }

    override suspend fun getUsers(call: ApplicationCall) {
        handleRequest(call) {
            getAllUsers()
        }
    }

    override suspend fun getUserById(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            getUserById(userId)
        }
    }

    override suspend fun save(call: ApplicationCall) {
        handleRequest(call) {
            val userRequest = call.receive<User>()
            require(userRequest.id.isNotBlank()) { "User ID cannot be null or empty" }
            saveUser(userRequest)
            HttpStatusCode.NoContent
        }
    }

    override suspend fun update(call: ApplicationCall) {
        handleRequest(call) {
            val userId = call.parameters["id"] ?: throw IllegalArgumentException(Constants.USER_ID_MISSING)
            val user = call.receive<User>()
            updateUserById(userId, user)
            HttpStatusCode.NoContent
        }
    }
}
