package domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Dex(
    val custom_dex: List<CustomDex> = emptyList(),
    var main_dex_catch: List<String> = emptyList()
)