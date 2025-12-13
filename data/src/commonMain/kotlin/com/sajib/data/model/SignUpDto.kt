package com.sajib.data.model

data class SignUpResponse(
    val access_token: String?= null,
    val expires_at: String ?= null,
    val message: List<String> = emptyList(),
    val result: Boolean,
    val token_type: String?= null,
    val user: User?= null
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