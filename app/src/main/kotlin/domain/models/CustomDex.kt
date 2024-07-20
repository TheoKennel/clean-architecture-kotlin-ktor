package domain.models

data class CustomDex(
    val firstFilterList: List<String>,
    val firstFilterName : List<String>,
    val name: String,
    val pkmCatch: List<String>,
    val pkmList: List<String>,
    val secondFilterList: List<String>,
    val secondFilterName: List<String>
)