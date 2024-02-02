package com.feylabs.snips.domain.uimodel

data class SnipsUIModel(
    val categoryLabel: String = "",
    val compressedImageUrl: String = "",
    val created: String = "",
    val description: String = "",
    val feyCover: String? = null,
    val iconUrl: String = "",
    val id: Int = 0,
    val imageUrl: String = "",
    val title: String = "",
    val url: String = ""
)
