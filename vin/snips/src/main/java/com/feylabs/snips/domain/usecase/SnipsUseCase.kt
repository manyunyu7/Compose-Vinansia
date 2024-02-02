package com.feylabs.snips.domain.usecase

import com.feylabs.core.helper.wrapper.ResponseState
import com.feylabs.snips.domain.uimodel.SnipsUIModel
import kotlinx.coroutines.flow.Flow

interface SnipsUseCase {
    suspend fun getAllSnips(
        categoryId: Int?,
        lastId: Int?,
        limit: Int?
    ): Flow<ResponseState<List<SnipsUIModel>>>

    fun getSnipsCache(
        lastId: Int?,
        categoryId: Int?,
        limit: Int?
    ): Flow<ResponseState<List<SnipsUIModel>>>
}