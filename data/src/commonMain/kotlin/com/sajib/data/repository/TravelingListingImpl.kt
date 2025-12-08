package com.sajib.data.repository

import com.sajib.data.datasources.DummyDataSource
import com.sajib.data.mapper.TravelListingMapper
import com.sajib.domain.model.TravelingListing
import com.sajib.domain.repository.ListingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class TravelingListingImpl(val dataSource: DummyDataSource) : ListingRepository {

    private val _listing = MutableStateFlow<List<TravelingListing>>(emptyList())
    val myListing: StateFlow<List<TravelingListing>> = _listing.asStateFlow()

    override fun getListing(): Flow<List<TravelingListing>> {
        return dataSource.listing.map { listing ->
            val domainModel = TravelListingMapper.toDomain(dtos = listing)
            _listing.value = domainModel
            myListing.value
        }
    }

    override fun getListingByID(id: String): Flow<TravelingListing> {
        return flow {
            _listing.value.find { it.id == id }
        }
    }
}