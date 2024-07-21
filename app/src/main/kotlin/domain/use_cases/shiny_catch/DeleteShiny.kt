package domain.use_cases.shiny_catch

import domain.error.ErrorHandler
import utils.UtilsResult

fun interface DeleteShiny {
    suspend operator fun invoke(userId: String): UtilsResult<Unit, ErrorHandler>
}

internal class DeleteShinyImpl(
    private val shinyRepository: ShinyRepository,
) : DeleteShiny {

    fun interface ShinyRepository {

        suspend fun delete(userId: String): UtilsResult<Unit, ErrorHandler>
    }

    override suspend fun invoke(userId: String): UtilsResult<Unit, ErrorHandler> = shinyRepository.delete(userId)
}