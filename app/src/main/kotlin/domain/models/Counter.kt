package domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Counter(
    val count: Int = 0,
    val method: Int = 0,
    val name: String = "",
    val regional_form: Int = 0,
    val regional_subform: Int = 0
)