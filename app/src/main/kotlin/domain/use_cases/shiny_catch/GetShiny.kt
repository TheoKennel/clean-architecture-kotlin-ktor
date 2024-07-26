package domain.use_cases.shiny_catch


import domain.models.ShinyCatch
import domain.use_cases.user.GetUserById

fun interface GetShiny {
    suspend operator fun invoke(userId: String): List<ShinyCatch>
}

internal class GetShinyImpl(
    private val shinyRepository: ShinyRepository,
    private val getUserById: GetUserById,
) : GetShiny {

    fun interface ShinyRepository {
        suspend fun get(userId: String): List<ShinyCatch>
    }

    override suspend fun invoke(userId: String): List<ShinyCatch> {
        val result = getUserById.invoke(userId)
        return result.shiny_catch ?: emptyList()
    }
}