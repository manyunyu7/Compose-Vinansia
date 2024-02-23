package com.feylabs.unboxing.data.source.remote.service

import com.feylabs.unboxing.data.source.remote.dto.SnipsResponseDTO
import com.feylabs.unboxing.data.source.remote.dto.unboxingDTO.ListUnboxingDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UnboxingAPI {

    @GET("snips/all")
    suspend fun getAllSnips(
        @Query("last_id") lastId: Int?,
        @Query("category_id") categoryId: Int?,
        @Query("limit") limit: Int?,
    ): Response<SnipsResponseDTO>

    @GET("unboxing/{category}")
    suspend fun getUnboxing(
        @Path("category") category: String?,
        @Query("last_id") lastId: Int?,
        @Query("category_id") categoryId: Int?,
        @Query("limit") limit: Int?,
        @Query("page") page: Int?,
    ): Response<ListUnboxingDTO>

}