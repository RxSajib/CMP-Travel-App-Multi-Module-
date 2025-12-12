package com.sajib.data.model

data class SignUpResponse(
    val access_token: String,
    val expires_at: String,
    val message: String,
    val result: Boolean,
    val token_type: String,
    val user: User
)

data class User(
    val avatar: String,
    val avatar_original: String,
    val email: String,
    val email_verified: Boolean,
    val id: Int,
    val name: String,
    val phone: String,
    val type: String
)