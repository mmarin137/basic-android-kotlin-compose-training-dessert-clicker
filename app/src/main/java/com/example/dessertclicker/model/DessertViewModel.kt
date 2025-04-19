package com.example.dessertclicker.model

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource.dessertList
import com.example.dessertclicker.model.state.DessertUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(DessertUiState())
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    init {
        val firstDessert = dessertList.first()
       _uiState.value = DessertUiState(currentDessertPrice = firstDessert.price, currentDessertImageId = firstDessert.imageId)
    }

    fun updateRevenueAndDessertData(revenue: Int, dessertsSold: Int, dessertImageId: Int, dessertPrice: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                revenue = revenue,
                dessertsSold = dessertsSold,
                currentDessertImageId = dessertImageId,
                currentDessertPrice = dessertPrice
            )
        }
    }


}