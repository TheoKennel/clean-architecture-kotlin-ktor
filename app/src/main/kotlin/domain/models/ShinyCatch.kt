package domain.models

import kotlinx.serialization.Serializable

@Serializable
data class ShinyCatch(
    val name: String = "",
    val regional_form: Int = 0,
    val regional_subform: Int = 0
)