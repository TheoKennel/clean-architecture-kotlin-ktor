package domain.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val account_name: String = "",
    val counters: List<Counter> = emptyList(),
    val dex: Dex = Dex(emptyList(), emptyList()),
    val shiny_catch: List<ShinyCatch> = emptyList(),
    val id: String = ""
)