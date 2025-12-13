package com.sajib.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class SignUpData(
    val name : String,
    val register_by : String,
    val email_or_phone : String,
    val password : String,
    val password_confirmation : String
)
