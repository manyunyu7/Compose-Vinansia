package com.feylabs.unboxing.data.repository

import android.net.ConnectivityManager
import com.feylabs.core.helper.error.ErrorResponse
import com.feylabs.core.helper.error.ResponseExceptionHandler
import com.feylabs.core.helper.network.NetworkInfo
import com.feylabs.core.helper.wrapper.ResponseState
import com.feylabs.unboxing.data.RemoteDataSource
import com.feylabs.unboxing.data.mapper.SnipMapper.toSnipsEntity
import com.feylabs.unboxing.data.mapper.SnipMapper.toSnipsUIModel
import com.feylabs.unboxing.data.mapper.UnboxingMapper.toUnboxingEntity
import com.feylabs.unboxing.data.mapper.UnboxingMapper.toUnboxingUIModel
import com.feylabs.unboxing.data.source.local.dao.SnipsDAO
import com.feylabs.unboxing.data.source.local.dao.UnboxingDAO
import com.feylabs.unboxing.di.UnboxingModule.ConnectivityManagerSnips
import com.feylabs.unboxing.domain.repository.UnboxingRepository
import com.feylabs.unboxing.domain.uimodel.SnipsUIModel
import com.feylabs.unboxing.domain.uimodel.UnboxingListItemUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UnboxingRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @ConnectivityManagerSnips private val connectivityManager: ConnectivityManager,
    private val snipLocalDataSource: SnipsDAO,
    private val unboxingLocalDataSource: UnboxingDAO
) : UnboxingRepository {

    override fun getAllSnips(categoryId: Int?, lastId: Int?, limit: Int?) =
        flow<ResponseState<List<SnipsUIModel>>> {
            emit(ResponseState.Loading())
            if (NetworkInfo.isOnline(connectivityManager)) {
                try {
                    val response = remoteDataSource.getAllSnips(lastId, categoryId, limit)
                    if (response.isSuccessful) {
                        val entityModels = response.body()?.data?.map { it.toSnipsEntity() }
                        snipLocalDataSource.apply {
                            deleteAll()
                            entityModels?.apply {
                                insertAll(entityModels)
                            }
                            emit(ResponseState.Success(getCachedSnips()))
                        }
                    } else {
                        emit(ResponseState.Error())
                    }
                } catch (e: Exception) {
                    ResponseExceptionHandler.handleException(e, this)
                }
            } else {
                val errorMessage = "Tidak Ada Koneksi Internet"
                if (getCachedSnips().isNotEmpty()) {
                    emit(ResponseState.Error(ErrorResponse(errorMessage = errorMessage)))
                    emit(ResponseState.Success(getCachedSnips()))
                } else {
                    emit(ResponseState.Error(ErrorResponse(errorMessage = errorMessage)))
                }
            }
        }.flowOn(Dispatchers.IO)

    override fun getUnboxing(category: String): Flow<ResponseState<List<UnboxingListItemUIModel>>> {
        return flow<ResponseState<List<UnboxingListItemUIModel>>> {
            emit(ResponseState.Loading())
            if (NetworkInfo.isOnline(connectivityManager)) {
                try {
                    val response = remoteDataSource.getUnboxing(category = category)
                    if (response.isSuccessful) {
                        val entityModels = response.body()?.data?.map { it.toUnboxingEntity() }
                        unboxingLocalDataSource.apply {
                            entityModels?.apply {
                                insertAll(entityModels)
                            }
                            emit(ResponseState.Success(getCachedUnboxing(category)))
                        }
                    } else {
                        emit(ResponseState.Error(ErrorResponse(response.message())))
                        delay(1000)
                        emit(ResponseState.Success(getCachedUnboxing(category)))
                    }
                } catch (e: Exception) {
                    ResponseExceptionHandler.handleException(e, this)
                }
            } else {
                val errorMessage = "Tidak Ada Koneksi Internet"
                if (getCachedUnboxing(category).isNotEmpty()) {
                    emit(ResponseState.Error(ErrorResponse(errorMessage = errorMessage)))
                    delay(5000)
                    emit(ResponseState.Success(getCachedUnboxing(category)))
                } else {
                    emit(ResponseState.Error(ErrorResponse(errorMessage = errorMessage)))
                }
            }
        }.flowOn(Dispatchers.IO)
    }

    private fun getCachedUnboxing(category: String): List<UnboxingListItemUIModel> {
        var localData = unboxingLocalDataSource.getAllByCategory(category)?.map {
            it.toUnboxingUIModel()
        }
        if (localData?.isEmpty()?.not() == true) {
            localData = unboxingLocalDataSource.getAllByCategory(category)?.map {
                it.toUnboxingUIModel()
            }
        }

        if (category == "all") {
            localData = unboxingLocalDataSource.getAll()?.map {
                it.toUnboxingUIModel()
            }
        }

        return localData ?: emptyList()
    }


    private fun getCachedSnips(): List<SnipsUIModel> {
        var localData = snipLocalDataSource.getAll()?.map {
            it.toSnipsUIModel()
        }
        if (localData?.isEmpty()?.not() == true) {
            localData = snipLocalDataSource.getAll()?.map {
                it.toSnipsUIModel()
            }
        }

        return localData ?: emptyList()

    }
}



