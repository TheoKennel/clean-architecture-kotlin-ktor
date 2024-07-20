package domain.use_cases.shiny_catch


import domain.error.ErrorHandler
import domain.models.ShinyCatch
import utils.UtilsResult

fun interface GetShiny {
    suspend operator fun invoke(): UtilsResult<List<ShinyCatch>, ErrorHandler>
}

internal class GetShinyImpl(
    private val shinyRepository: ShinyRepository,
) : GetShiny {

    fun interface ShinyRepository {
        suspend fun get(): UtilsResult<List<ShinyCatch>, ErrorHandler>
    }

    override suspend fun invoke(): UtilsResult<List<ShinyCatch>, ErrorHandler> = shinyRepository.get()
}