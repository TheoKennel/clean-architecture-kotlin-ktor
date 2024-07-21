package domain.use_cases.shiny_catch


import domain.error.ErrorHandler
import domain.models.ShinyCatch
import utils.UtilsResult

fun interface GetShiny {
    suspend operator fun invoke(userId: String): UtilsResult<List<ShinyCatch>, ErrorHandler>
}

internal class GetShinyImpl(
    private val shinyRepository: ShinyRepository,
) : GetShiny {

    fun interface ShinyRepository {
        suspend fun get(userId: String): UtilsResult<List<ShinyCatch>, ErrorHandler>
    }

    override suspend fun invoke(userId: String): UtilsResult<List<ShinyCatch>, ErrorHandler> =
        shinyRepository.get(userId)
}