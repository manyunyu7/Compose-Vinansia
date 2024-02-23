package com.feylabs.unboxing.data.source.remote.dto.unboxingDTO


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class UnboxingItemDTO(
    @SerializedName("category")
    var category: String? = null,
    @SerializedName("compressed_thumbnail_url")
    var compressedThumbnailUrl: String? = null,
    @SerializedName("created_at")
    var createdAt: String? = null,
    @SerializedName("date")
    var date: String? = null,
    @SerializedName("date_display")
    var dateDisplay: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("description_masked")
    var descriptionMasked: String? = null,
    @SerializedName("fey_cover")
    var feyCover: String? = null,
    @SerializedName("files")
    var files: List<Any>? = null,
    @SerializedName("id")
    var id: Int = -99,
    @SerializedName("image_url_full")
    var imageUrlFull: String? = null,
    @SerializedName("image_url_wide")
    var imageUrlWide: String? = null,
    @SerializedName("masks")
    var masks: List<Any>? = null,
    @SerializedName("status")
    var status: String? = null,
    @SerializedName("thumbnail_url")
    var thumbnailUrl: String? = null,
    @SerializedName("image_url")
    var imageUrl: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("updated_at")
    var updatedAt: String? = null,
    @SerializedName("volume")
    var volume: Int? = null
) {

}