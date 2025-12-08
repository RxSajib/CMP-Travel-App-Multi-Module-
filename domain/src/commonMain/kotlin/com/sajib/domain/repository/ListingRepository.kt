package com.sajib.domain.repository

import com.sajib.domain.model.TravelingListing
import kotlinx.coroutines.flow.Flow

interface ListingRepository {

    fun getListing() : Flow<List<TravelingListing>>
    fun getListingByID(id : String) : Flow<TravelingListing>
}