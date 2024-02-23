package com.feylabs.unboxing.data.source.local.entity

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "unboxing_items")
data class UnboxingEntity(
    @PrimaryKey val id: Int,
    val imageUrl: String = "",
    val compressedImageUrl: String = "",
    val title: String = "",
    val description: String = "",
    val category: String = "",
    val date: String = "",
    val url: String = "",
    val feycover: String = "",
    val volume: Int? = 0,
    val status: String = "",
) {
}

