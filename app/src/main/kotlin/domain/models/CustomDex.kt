package domain.models

import kotlinx.serialization.Serializable

@Serializable
data class CustomDex(
    var firstFilterList: List<String>,
    val firstFilterName : List<String>,
    var name: String,
    var pkmCatch: List<String>,
    var pkmList: List<String>,
    var secondFilterList: List<String>,
    var secondFilterName: String
)