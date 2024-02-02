package com.feylabs.snips.data.source.local.entity

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "snips_items")
data class SnipsEntity(
    @PrimaryKey val id: Int,
    val categoryLabel: String = "",
    val compressedImageUrl: String = "",
    val created: String = "",
    val description: String = "",
    val feyCover: String? = null,
    val iconUrl: String = "",
    val imageUrl: String = "",
    val title: String = "",
    val url: String = ""
)

