package com.sajib.data.mapper

import com.sajib.data.model.TRavelListingDto
import com.sajib.domain.model.TravelingListing

object TravelListingMapper {

    fun toDomain(dto: TRavelListingDto): TravelingListing {
        return TravelingListing(
            id = dto.id,
            title = dto.title,
            details = dto.details,
            location = dto.location,
            imageUri = dto.imageUri,
            priceParNight = dto.priceParNight,
            rating = dto.rating,
            ametites = dto.ametites,
            hostName = dto.hostName,
            isFavorite = dto.isFavorite
        )
    }

    fun toDomain(dtos : List<TRavelListingDto>) : List<TravelingListing> {
        return dtos.map {singleTravlingListing ->
            toDomain(singleTravlingListing)
        }

    }
}