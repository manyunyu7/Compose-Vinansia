package com.feylabs.snips.domain.repository

import com.feylabs.core.helper.wrapper.ResponseState
import com.feylabs.snips.domain.uimodel.SnipsUIModel
import kotlinx.coroutines.flow.Flow

interface SnipsRepository {
    fun getAllSnips(
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