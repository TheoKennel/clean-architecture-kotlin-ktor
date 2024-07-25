package domain.use_cases.shiny_catch

import domain.error.ErrorHandler
import domain.models.ShinyCatch
import utils.UtilsResult

fun interface SaveOrUpdateShiny {
    suspend operator fun invoke(userId: String, shinyCatch:  List<ShinyCatch>)
}

internal class SaveOrUpdateShinyImpl(
    private val shinyRepository: ShinyRepository
): SaveOrUpdateShiny {

    fun interface ShinyRepository {

        suspend fun add(userId: String, shinyCatch: List<ShinyCatch>)
    }

    override suspend fun invoke(userId: String, shinyCatch: List<ShinyCatch>) = shinyRepository.add(userId, shinyCatch)
}