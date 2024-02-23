package com.feylabs.unboxing.data.mapper

import com.feylabs.unboxing.data.source.local.entity.SnipsEntity
import com.feylabs.unboxing.domain.uimodel.SnipsUIModel
import com.feylabs.unboxing.data.source.remote.dto.Data as SnipsDTO

object SnipMapper {

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