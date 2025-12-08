package com.sajib.data.datasources

import com.sajib.data.model.TRavelListingDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DummyDataSource{

    private val _listing = MutableStateFlow(sampleTravelList())
    val listing = _listing.asStateFlow()


    fun sampleTravelList() : List<TRavelListingDto> = listOf(
        TRavelListingDto(
            id = "1",
            title = "Seaside Paradise Resort",
            details = "Beautiful ocean view resort with private beach access.",
            location = "Cox’s Bazar, Bangladesh",
            imageUri = "https://img.freepik.com/free-photo/full-shot-travel-concept-with-landmarks_23-2149153258.jpg?semt=ais_hybrid&w=740&q=80",
            priceParNight = 4500.0,
            rating = 4.8,
            ametites = listOf("WiFi", "Pool", "Breakfast"),
            hostName = "Rahim",
            isFavorite = false
        ),
        TRavelListingDto(
            id = "2",
            title = "Mountain Hill Cottage",
            details = "Peaceful cottage surrounded by green hills.",
            location = "Bandarban, Bangladesh",
            imageUri = "https://example.com/img2.jpg",
            priceParNight = 3800.0,
            rating = 4.6,
            ametites = listOf("WiFi", "Parking"),
            hostName = "Karim",
            isFavorite = true
        ),
        TRavelListingDto(
            id = "3",
            title = "City Light Luxury Apartment",
            details = "Modern apartment in the heart of the city.",
            location = "Dhaka, Bangladesh",
            imageUri = "https://example.com/img3.jpg",
            priceParNight = 5200.0,
            rating = 4.7,
            ametites = listOf("WiFi", "Gym"),
            hostName = "Sadia",
            isFavorite = false
        ),
        TRavelListingDto(
            id = "4",
            title = "Riverside Eco Resort",
            details = "Eco-friendly resort beside the calm river.",
            location = "Sylhet, Bangladesh",
            imageUri = "https://example.com/img4.jpg",
            priceParNight = 4100.0,
            rating = 4.5,
            ametites = listOf("WiFi", "Breakfast"),
            hostName = "Jamil",
            isFavorite = false
        ),
        TRavelListingDto(
            id = "5",
            title = "Heritage Villa Stay",
            details = "Vintage designed villa with premium comfort.",
            location = "Rajshahi, Bangladesh",
            imageUri = "https://example.com/img5.jpg",
            priceParNight = 3900.0,
            rating = 4.4,
            ametites = listOf("WiFi", "Garden"),
            hostName = "Nadia",
            isFavorite = true
        ),
        TRavelListingDto(
            id = "6",
            title = "Jungle Adventure Lodge",
            details = "Stay close to nature in a jungle-themed lodge.",
            location = "Sreemangal, Bangladesh",
            imageUri = "https://example.com/img6.jpg",
            priceParNight = 3500.0,
            rating = 4.3,
            ametites = listOf("Breakfast", "Guide"),
            hostName = "Ratul",
            isFavorite = false
        ),
        TRavelListingDto(
            id = "7",
            title = "Island Breeze Bungalow",
            details = "Calm and breezy bungalow near the island shore.",
            location = "Saint Martin, Bangladesh",
            imageUri = "https://example.com/img7.jpg",
            priceParNight = 4800.0,
            rating = 4.7,
            ametites = listOf("WiFi", "Beach Access"),
            hostName = "Tania",
            isFavorite = false
        ),
        TRavelListingDto(
            id = "8",
            title = "Urban Studio Room",
            details = "Affordable studio room for business travelers.",
            location = "Chattogram, Bangladesh",
            imageUri = "https://example.com/img8.jpg",
            priceParNight = 3200.0,
            rating = 4.2,
            ametites = listOf("WiFi", "Parking"),
            hostName = "Hasan",
            isFavorite = true
        ),
        TRavelListingDto(
            id = "9",
            title = "Countryside Family Home",
            details = "Spacious home perfect for family vacations.",
            location = "Kushtia, Bangladesh",
            imageUri = "https://example.com/img9.jpg",
            priceParNight = 3000.0,
            rating = 4.3,
            ametites = listOf("Kitchen", "WiFi"),
            hostName = "Salma",
            isFavorite = false
        ),
        TRavelListingDto(
            id = "10",
            title = "Lake View Wooden Cabin",
            details = "Cozy cabin with direct lake view.",
            location = "Rangamati, Bangladesh",
            imageUri = "https://example.com/img10.jpg",
            priceParNight = 3600.0,
            rating = 4.6,
            ametites = listOf("Boat Ride", "WiFi"),
            hostName = "Noman",
            isFavorite = false
        ),
        TRavelListingDto(
            id = "11",
            title = "Sky Tower Premium Suite",
            details = "High-rise luxury suite with panoramic view.",
            location = "Dhaka, Bangladesh",
            imageUri = "https://example.com/img11.jpg",
            priceParNight = 8500.0,
            rating = 4.9,
            ametites = listOf("WiFi", "Gym", "Pool"),
            hostName = "Rafi",
            isFavorite = true
        ),
        TRavelListingDto(
            id = "12",
            title = "Deserted Serenity Resort",
            details = "Quiet and peaceful resort for relaxation.",
            location = "Barishal, Bangladesh",
            imageUri = "https://example.com/img12.jpg",
            priceParNight = 3400.0,
            rating = 4.2,
            ametites = listOf("Breakfast", "WiFi"),
            hostName = "Sultana",
            isFavorite = false
        ),
        TRavelListingDto(
            id = "13",
            title = "Cultural Heritage Homestay",
            details = "Experience traditional Bangladeshi culture.",
            location = "Pabna, Bangladesh",
            imageUri = "https://example.com/img13.jpg",
            priceParNight = 2800.0,
            rating = 4.1,
            ametites = listOf("Traditional Food"),
            hostName = "Nazmul",
            isFavorite = true
        ),
        TRavelListingDto(
            id = "14",
            title = "Beach Sunset Resort",
            details = "Resort with stunning sunset view every evening.",
            location = "Kuakata, Bangladesh",
            imageUri = "https://example.com/img14.jpg",
            priceParNight = 4400.0,
            rating = 4.6,
            ametites = listOf("WiFi", "Breakfast", "Pool"),
            hostName = "Imran",
            isFavorite = false
        ),
        TRavelListingDto(
            id = "15",
            title = "Luxury Forest Retreat",
            details = "Premium forest resort with full comfort.",
            location = "Khagrachari, Bangladesh",
            imageUri = "https://example.com/img15.jpg",
            priceParNight = 5000.0,
            rating = 4.8,
            ametites = listOf("Spa", "WiFi"),
            hostName = "Fahim",
            isFavorite = true
        )
    )


}