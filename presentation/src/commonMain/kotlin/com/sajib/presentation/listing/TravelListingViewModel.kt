package com.sajib.presentation.listing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sajib.domain.usecase.GetAllListingUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TravelListingViewModel constructor(val getAllListingUseCase: GetAllListingUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(TravelListingUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getTravelListing()
    }

    private fun getTravelListing(){
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null, data = emptyList())
            delay(3000)
            try {
                getAllListingUseCase.execute().collect { listing ->
                    _uiState.emit(_uiState.value.copy(isLoading = false, errorMessage = null, data = listing))
                }
            }catch (e : Exception){
                _uiState.value = _uiState.value.copy(isLoading = false, errorMessage = e.message, data = emptyList())
            }
        }
    }
}