package com.sajib.data.model

data class TRavelListingDto(
    val id : String,
    val title : String,
    val details : String,
    val location : String,
    val imageUri : String,
    val priceParNight : Double,
    val rating : Double,
    val ametites : List<String> = emptyList(),
    val hostName : String,
    val isFavorite : Boolean = false
)
