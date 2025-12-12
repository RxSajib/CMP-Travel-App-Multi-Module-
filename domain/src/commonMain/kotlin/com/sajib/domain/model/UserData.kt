package com.sajib.domain.model

data class UserData(
    val token : String,
    val emailAddress : String,
    val userID : Int,
    val name : String,
    val phone : String,
    val avatar: String,
    val avatar_original: String
)
