package com.feylabs.unboxing.data

import com.feylabs.unboxing.data.source.remote.dto.SnipsResponseDTO
import com.feylabs.unboxing.data.source.remote.dto.unboxingDTO.ListUnboxingDTO
import com.feylabs.unboxing.data.source.remote.service.UnboxingAPI
import com.feylabs.unboxing.di.UnboxingModule
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    @UnboxingModule.UnboxingSnips private val api: UnboxingAPI
) {
    suspend fun getAllSnips(
        lastId: Int?,
        categoryId: Int?,
        limit: Int?
    ): Response<SnipsResponseDTO> {
        return api.getAllSnips(lastId, categoryId, limit)
    }

    suspend fun getUnboxing(category: String): Response<ListUnboxingDTO> {
        return api.getUnboxing(
            category = category,
            limit = null,
            categoryId = null,
            lastId = null,
            page = null
        )
    }
}