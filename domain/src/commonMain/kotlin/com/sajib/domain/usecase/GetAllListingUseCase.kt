package com.sajib.domain.usecase

import com.sajib.domain.model.TravelingListing
import com.sajib.domain.repository.ListingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllListingUseCase( val listingRepository: ListingRepository) {

    fun execute() : Flow<List<TravelingListing>> {
        val data = listingRepository.getListing()
        data.map {
            it.sortedByDescending {listing ->
                listing.rating
            }
        }
        return data
    }
}