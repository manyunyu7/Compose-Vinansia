package com.feylabs.unboxing.data.source.remote.dto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class SnipsResponseDTO(
    @SerializedName("data")
    var `data`: List<Data> = listOf(),
    @SerializedName("item_count")
    var itemCount: Int = 0,
    @SerializedName("message")
    var message: String = ""
)