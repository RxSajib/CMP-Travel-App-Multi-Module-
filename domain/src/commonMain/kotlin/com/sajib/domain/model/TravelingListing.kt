package com.sajib.domain.model

data class TravelingListing(
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
){
    fun getFormattedPrice() : String {
        return "$priceParNight / night"
    }

    fun getRatingDescriptions() : String {
        return  when{
            rating >= 4.8 -> "Exceptional"
            rating >= 4.5 -> "Excellent"
            rating >= 4.0 -> "Very Good"
            rating >= 3.5 -> "Good"
            rating >= 3.0 -> "Average"
            else -> "Bellow Average"
        }
    }
}
