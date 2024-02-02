package com.feylabs.snips.data.source.remote.dto


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class SnipsResponseDTO(
    @SerializedName("data")
    var `data`: List<Data> = listOf(),
    @SerializedName("item_count")
    var itemCount: Int = 0,
    @SerializedName("message")
    var message: String = ""
)