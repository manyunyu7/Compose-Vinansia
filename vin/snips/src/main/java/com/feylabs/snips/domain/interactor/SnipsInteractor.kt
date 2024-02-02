package com.feylabs.snips.domain.interactor

import com.feylabs.core.helper.wrapper.ResponseState
import com.feylabs.snips.domain.repository.SnipsRepository
import com.feylabs.snips.domain.uimodel.SnipsUIModel
import com.feylabs.snips.domain.usecase.SnipsUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SnipsInteractor @Inject constructor(
    private val snipsRepository: SnipsRepository
) : SnipsUseCase {

    override suspend fun getAllSnips(
        categoryId: Int?,
        lastId: Int?,
        limit: Int?
    ): Flow<ResponseState<List<SnipsUIModel>>> {
        return snipsRepository.getAllSnips(categoryId, lastId, limit)
    }

    override fun getSnipsCache(
        lastId: Int?,
        categoryId: Int?,
        limit: Int?
    ): Flow<ResponseState<List<SnipsUIModel>>> {
        return snipsRepository.getSnipsCache(
            lastId = lastId,
            categoryId = categoryId,
            limit = limit
        )
    }

}