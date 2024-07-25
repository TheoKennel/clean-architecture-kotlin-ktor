package domain.use_cases.shiny_catch


import domain.error.ErrorHandler
import domain.models.ShinyCatch
import utils.UtilsResult

fun interface GetShiny {
    suspend operator fun invoke(userId: String): List<ShinyCatch>
}

internal class GetShinyImpl(
    private val shinyRepository: ShinyRepository,
) : GetShiny {

    fun interface ShinyRepository {
        suspend fun get(userId: String): List<ShinyCatch>
    }

    override suspend fun invoke(userId: String): List<ShinyCatch> =
        shinyRepository.get(userId)
}