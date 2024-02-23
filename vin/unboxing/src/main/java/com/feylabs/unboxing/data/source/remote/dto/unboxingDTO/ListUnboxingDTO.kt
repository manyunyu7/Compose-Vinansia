package com.feylabs.unboxing.data.source.remote.dto.unboxingDTO


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ListUnboxingDTO(
    @SerializedName("data")
    var `data`: List<UnboxingItemDTO> = listOf(),
    @SerializedName("item_count")
    var itemCount: Int = 0,
    @SerializedName("message")
    var message: String = ""
)