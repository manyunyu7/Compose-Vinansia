package com.feylabs.unboxing.domain.uimodel

data class UnboxingListItemUIModel(
    val id: Int? = -99,
    val imageUrl: String = "",
    val compressedImageUrl: String = "",
    val title: String = "",
    val description: String = "",
    val date: String = "",
    val url: String = "jirrr",
    val feycover: String = "",
    val volume: Int? = 0,
    val status: String = "",
    val category: String = "",
)

