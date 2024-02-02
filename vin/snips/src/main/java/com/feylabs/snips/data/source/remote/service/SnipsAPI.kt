package com.feylabs.snips.data.source.remote.service

import com.feylabs.snips.data.source.remote.dto.SnipsResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SnipsAPI {

    @GET("snips/all")
    suspend fun getAllSnips(
        @Query("last_id") lastId: Int?,
        @Query("category_id") categoryId: Int?,
        @Query("limit") limit: Int?,
    ): Response<SnipsResponseDTO>

}