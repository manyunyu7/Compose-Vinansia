package com.feylabs.unboxing.domain.usecase

import com.feylabs.core.helper.wrapper.ResponseState
import com.feylabs.unboxing.domain.uimodel.SnipsUIModel
import com.feylabs.unboxing.domain.uimodel.UnboxingListItemUIModel
import kotlinx.coroutines.flow.Flow

interface UnboxingUseCase {
    suspend fun getAllSnips(
        categoryId: Int?,
        lastId: Int?,
        limit: Int?
    ): Flow<ResponseState<List<SnipsUIModel>>>

    suspend fun getUnboxing(
        category: String?
    ): Flow<ResponseState<List<UnboxingListItemUIModel>>>
}