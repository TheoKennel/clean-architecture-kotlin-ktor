package domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Dex(
    val customDex: List<CustomDex>,
    var mainDexCatch: List<String>
)