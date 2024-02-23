package com.feylabs.unboxing.data.source.remote.dto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Data(
    @SerializedName("category_label")
    var categoryLabel: String = "",
    @SerializedName("compressed_image_url")
    var compressedImageUrl: String = "",
    @SerializedName("created")
    var created: String = "",
    @SerializedName("description")
    var description: String = "",
    @SerializedName("fey_cover")
    var feyCover: String? = "",
    @SerializedName("icon_url")
    var iconUrl: String = "",
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("image_url")
    var imageUrl: String = "",
    @SerializedName("title")
    var title: String = "",
    @SerializedName("url")
    var url: String = ""
)