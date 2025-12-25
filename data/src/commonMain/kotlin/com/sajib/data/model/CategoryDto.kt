package com.sajib.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CategoryDto(
    val `data`: List<Data>,
    val status: Int,
    val success: Boolean
)

@Serializable
data class Data(
    val banner: String,
    val icon: String,
    val id: Int,
    val links: Links,
    val name: String,
    val number_of_children: Int
)

@Serializable
data class Links(
    val products: String,
    val sub_categories: String
)