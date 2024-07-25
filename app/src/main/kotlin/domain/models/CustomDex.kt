package domain.models

import kotlinx.serialization.Serializable

@Serializable
data class CustomDex(
    var first_filter_list: List<String> = emptyList(),
    val first_filter_name : String = "",
    var name: String = "",
    var pkm_catch: List<String> = emptyList(),
    var pkm_list: List<String> = emptyList(),
    var second_filter_list: List<String> = emptyList(),
    var second_filter_name: String = ""
)
