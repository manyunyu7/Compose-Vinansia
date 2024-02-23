package com.feylabs.unboxing.data.mapper

import com.feylabs.unboxing.data.source.local.entity.UnboxingEntity
import com.feylabs.unboxing.data.source.remote.dto.unboxingDTO.UnboxingItemDTO
import com.feylabs.unboxing.domain.uimodel.UnboxingListItemUIModel

object UnboxingMapper {

    fun UnboxingItemDTO.toUnboxingUIModel(): UnboxingListItemUIModel {
        return UnboxingListItemUIModel(
            compressedImageUrl = this.compressedThumbnailUrl.orEmpty(),
            description = this.description.orEmpty(),
            id = this.id,
            imageUrl = this.thumbnailUrl.orEmpty(),
            title = this.title.orEmpty(),
            url = "",
            status = this.status.orEmpty(),
            date = this.date.orEmpty(),
            feycover = this.feyCover.orEmpty(),
            volume = this.volume,
            category = this.category.orEmpty()
        )
    }

    fun UnboxingItemDTO.toUnboxingEntity(): UnboxingEntity {
        return UnboxingEntity(
            compressedImageUrl = this.compressedThumbnailUrl.orEmpty(),
            description = this.description.orEmpty(),
            id = this.id,
            imageUrl = this.thumbnailUrl.orEmpty(),
            title = this.title.orEmpty(),
            url = "",
            status = this.status.orEmpty(),
            date = this.date.orEmpty(),
            feycover = this.feyCover.orEmpty(),
            volume = this.volume,
            category = this.category.mapCategory()
        )
    }

    fun UnboxingEntity.toUnboxingUIModel(): UnboxingListItemUIModel {
        return UnboxingListItemUIModel(
            compressedImageUrl = this.compressedImageUrl,
            description = this.description,
            id = this.id,
            imageUrl = this.imageUrl,
            title = this.title,
            url = "",
            status = this.status,
            date = this.date,
            feycover = this.feycover.orEmpty(),
            volume = this.volume,
            category = this.category
        )
    }


    private fun String?.mapCategory(): String {
        if (this == "UNBOXING_CATEGORY_EMITTEN")
            return "stock"
        if (this == "UNBOXING_CATEGORY_SECTOR")
            return "sectoral"
        return ""
    }

}

