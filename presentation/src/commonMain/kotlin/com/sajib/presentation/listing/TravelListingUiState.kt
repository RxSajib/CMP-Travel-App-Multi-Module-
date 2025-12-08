package com.sajib.presentation.listing

import com.sajib.domain.model.TravelingListing

data class TravelListingUiState(
    val data : List<TravelingListing> = emptyList(),
    val isLoading :  Boolean = false,
    val errorMessage : String? = null
)
