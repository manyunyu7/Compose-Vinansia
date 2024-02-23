package com.feylabs.unboxing.domain.repository

import com.feylabs.core.helper.wrapper.ResponseState
import com.feylabs.unboxing.domain.uimodel.SnipsUIModel
import com.feylabs.unboxing.domain.uimodel.UnboxingListItemUIModel
import kotlinx.coroutines.flow.Flow

interface UnboxingRepository {
    fun getAllSnips(
        categoryId: Int?,
        lastId: Int?,
        limit: Int?
    ): Flow<ResponseState<List<SnipsUIModel>>>

    fun getUnboxing(
        category: String
    ): Flow<ResponseState<List<UnboxingListItemUIModel>>>

}