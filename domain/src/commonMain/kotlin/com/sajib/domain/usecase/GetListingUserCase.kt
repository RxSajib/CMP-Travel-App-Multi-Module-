package com.sajib.domain.usecase

import com.sajib.domain.model.TravelingListing
import com.sajib.domain.repository.ListingRepository
import kotlinx.coroutines.flow.Flow

class GetListingUserCase(private val listingRepository: ListingRepository) {

    fun execute(id: String): Flow<TravelingListing> {
        return listingRepository.getListingByID(id = id)
    }
}

