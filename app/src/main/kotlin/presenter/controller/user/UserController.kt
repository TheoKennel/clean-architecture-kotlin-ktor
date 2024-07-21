package presenter.controller.user

import io.ktor.server.application.*

interface UserController {
    suspend fun deleteUser(call: ApplicationCall)
    suspend fun getUsers(call: ApplicationCall)
    suspend fun getUserById(call: ApplicationCall)
    suspend fun save(call: ApplicationCall)
    suspend fun update(call: ApplicationCall)
}