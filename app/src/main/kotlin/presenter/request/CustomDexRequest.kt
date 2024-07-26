package presenter.request

import kotlinx.serialization.Serializable

@Serializable
data class UpdateCustomDexNameRequest(val name: String)

@Serializable
data class UpdateCustomDexPkmListRequest(val pkm_list: List<String>)

@Serializable
data class UpdateCustomDexPkmCatchRequest(val pkm_catch: List<String>)

@Serializable
data class UpdateCustomDexSecondFilterListRequest(val second_filter_list: List<String>)

@Serializable
data class UpdateCustomDexSecondFilterListNameRequest(val second_filter_name: String)

@Serializable
data class UpdateCustomDexFirstFilterListRequest(val first_filter_list: List<String>)
@Serializable
data class UpdateCustomDexFirstFilterNameRequest(val first_filter_name: String)

