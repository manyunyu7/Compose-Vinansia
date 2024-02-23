package com.feylabs.unboxing.domain.interactor

import com.feylabs.core.helper.wrapper.ResponseState
import com.feylabs.unboxing.domain.repository.UnboxingRepository
import com.feylabs.unboxing.domain.uimodel.SnipsUIModel
import com.feylabs.unboxing.domain.uimodel.UnboxingListItemUIModel
import com.feylabs.unboxing.domain.usecase.UnboxingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UnboxingInteractor @Inject constructor(
    private val unboxingRepository: UnboxingRepository
) : UnboxingUseCase {

    override suspend fun getAllSnips(
        categoryId: Int?,
        lastId: Int?,
        limit: Int?
    ): Flow<ResponseState<List<SnipsUIModel>>> {
        return unboxingRepository.getAllSnips(categoryId, lastId, limit)
    }

    override suspend fun getUnboxing(category: String?): Flow<ResponseState<List<UnboxingListItemUIModel>>> {
        return unboxingRepository.getUnboxing(category ?: "all")
    }

}