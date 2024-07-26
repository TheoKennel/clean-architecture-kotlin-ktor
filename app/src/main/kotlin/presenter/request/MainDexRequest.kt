package presenter.request

import kotlinx.serialization.Serializable

@Serializable
data class MainDexRequest(
    val main_dex_catch : List<String>
)
