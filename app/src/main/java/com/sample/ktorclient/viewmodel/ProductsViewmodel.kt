package com.sample.ktorclient.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.ktorclient.util.toNetworkError
import com.sample.networking.data.response.Products
import com.sample.networking.repository.ProductsRepository
import com.sample.networking.result.NetworkError
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductsViewmodel(val productsRepository : ProductsRepository) : ViewModel() {

    private val _viewStateFlow = MutableStateFlow<ViewState>(ViewState.InitialState)
    val viewState : StateFlow<ViewState> = _viewStateFlow.asStateFlow()

    fun getProducts() {
        updateState(ViewState.LoadingState.Show)
        viewModelScope.launch {
            productsRepository.getProductsList()
                .onSuccess {
                    updateState(ViewState.LoadingState.Hide)
                    it?.let { data ->
                        updateState(ViewState.SuccessState.Product(data))
                    }
                }
                .onFailure {
                    updateState(ViewState.LoadingState.Hide)
                    updateState(ViewState.ErrorState.Error(it.toNetworkError()))
                }
        }
    }

    private fun updateState(viewState: ViewState) {
        _viewStateFlow.value = viewState
    }

    sealed class ViewState {
        data object InitialState : ViewState()
        sealed class LoadingState : ViewState() {
            data object Show : LoadingState()
            data object Hide : LoadingState()
        }
        sealed class SuccessState : ViewState() {
            data class Product(val data: Products?) : SuccessState()
        }
        sealed class ErrorState : ViewState() {
            data class Error(val toNetworkError: NetworkError) : ErrorState()
        }
    }
}
