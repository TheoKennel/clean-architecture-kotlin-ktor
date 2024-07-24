package domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Counter(
    val count: Int,
    val method: Int,
    val name: String,
    val regionalForm: Int,
    val regionalSubform: Int
)