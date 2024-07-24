package domain.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val accountName: String,
    val counters: List<Counter>,
    val dex: Dex,
    val shinyCatch: List<ShinyCatch>,
    val id: String
)
