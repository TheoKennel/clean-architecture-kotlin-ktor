package domain.models

import kotlinx.serialization.Serializable

@Serializable
data class ShinyCatch(
    val name: String,
    val regionalForm: Int,
    val regionalSubform: Int
)
