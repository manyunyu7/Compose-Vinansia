package com.feylabs.snips.data.mapper

import com.feylabs.snips.data.source.local.entity.SnipsEntity
import com.feylabs.snips.data.source.remote.dto.Data as SnipsDTO
import com.feylabs.snips.domain.uimodel.SnipsUIModel

object Mapper {

    fun SnipsDTO.toSnipUIModel(): SnipsUIModel {
        return SnipsUIModel(
            categoryLabel = this.categoryLabel,
            compressedImageUrl = this.compressedImageUrl,
            created = this.created,
            description = this.description,
            feyCover = this.feyCover,
            iconUrl = this.iconUrl,
            id = this.id,
            imageUrl = this.imageUrl,
            title = this.title,
            url = this.url
        )
    }

    fun SnipsDTO.toSnipsEntity(): SnipsEntity {
        return SnipsEntity(
            categoryLabel = this.categoryLabel,
            compressedImageUrl = this.compressedImageUrl,
            created = this.created,
            description = this.description,
            feyCover = this.feyCover,
            iconUrl = this.iconUrl,
            id = this.id,
            imageUrl = this.imageUrl,
            title = this.title,
            url = this.url
        )
    }

    fun SnipsEntity.toSnipsUIModel(): SnipsUIModel {
        return SnipsUIModel(
            categoryLabel = this.categoryLabel,
            compressedImageUrl = this.compressedImageUrl,
            created = this.created,
            description = this.description,
            feyCover = this.feyCover,
            iconUrl = this.iconUrl,
            id = this.id,
            imageUrl = this.imageUrl,
            title = this.title,
            url = this.url
        )
    }


}