package com.feylabs.vinansia.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feylabs.core.helper.wrapper.ResponseState
import com.feylabs.snips.domain.uimodel.SnipsUIModel
import com.feylabs.snips.domain.usecase.SnipsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SnipsHomeViewModel @Inject constructor(
//    private val unboxingUseCase: UnboxingUseCase,
    private val snipUseCase: SnipsUseCase,
) :
    ViewModel() {

//    private val _unboxingSectoralListValue = MutableStateFlow(UnboxingState())
//    val unboxingSectoralListValue: StateFlow<UnboxingState> = _unboxingSectoralListValue
//
//    private val _unboxingStockListValue = MutableStateFlow(UnboxingState())
//    val unboxingStockListValue: StateFlow<UnboxingState> = _unboxingStockListValue

    private var _snipListValue = MutableStateFlow(SnipsListState())
    val snipListValue: StateFlow<SnipsListState> = _snipListValue

//    private var _transactionListValue = MutableStateFlow(TransactionListState())
//    val transactionListValue: StateFlow<TransactionListState> = _transactionListValue

    private var _addTransactionValue = MutableStateFlow(AddTransactionState())
    val addTransactionValue: StateFlow<AddTransactionState> = _addTransactionValue

    fun getData() {
        fetchSnip()
//        fetchUnboxingData("sectoral", _unboxingSectoralListValue)
//        fetchUnboxingData("stock", _unboxingStockListValue)
    }

//    data class UnboxingState(
//        val isLoading: Boolean = false,
//        val unboxingList: List<UnboxingListItemUIModel> = emptyList(),
//        val error: String = ""
//    )

    class AddTransactionState(
        val isLoading: Boolean = false,
        var error: String = "",
        var success: String = ""
    )


    class SnipsListState(
        val isLoading: Boolean = false,
        val snipList: List<SnipsUIModel> = emptyList<SnipsUIModel>(),
        var error: String = ""
    )


    fun getUnboxingStock() {
//        fetchUnboxingData("stock", _unboxingStockListValue)
    }

    fun getUnboxingSectoral() {
//        fetchUnboxingData("sectoral", _unboxingSectoralListValue)
    }

    fun getSnip() {
        fetchSnip(categoryId = 1, limit = 100)
    }

//    private fun fetchUnboxingData(type: String, state: MutableStateFlow<UnboxingState>) {
//        viewModelScope.launch(Dispatchers.IO) {
//            unboxingUseCase.getUnboxing(type).collect {
//                when (it) {
//                    is ResponseState.Loading -> state.value = UnboxingState(isLoading = true)
//                    is ResponseState.Success -> state.value =
//                        UnboxingState(unboxingList = it.data ?: emptyList())
//                    is ResponseState.Error -> state.value = UnboxingState(
//                        isLoading = false,
//                        error = it.errorResponse?.errorMessage.toString()
//                    )
//                }
//            }
//        }
//    }

    fun fetchSnip(lastId: Int? = null, categoryId: Int? = null, limit: Int? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            snipUseCase.getAllSnips(lastId = lastId, categoryId = categoryId, limit = limit)
                .collect {
                    when (it) {
                        is ResponseState.Loading -> {
                            _snipListValue.value = SnipsListState(
                                isLoading = true
                            )
                        }

                        is ResponseState.Success -> {
                            _snipListValue.value = SnipsListState(
                                snipList = it.data ?: emptyList()
                            )
                        }

                        is ResponseState.Error -> {
                            _snipListValue.value = SnipsListState(
                                isLoading = false,
                                error = it.errorResponse?.errorMessage.toString()
                            )
                        }
                    }
                }
        }
    }
}

