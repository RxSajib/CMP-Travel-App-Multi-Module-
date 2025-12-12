package com.sajib.presentation.ui.signupScreen

import com.sajib.data.model.request.SignUpData

data class SignUpState(
    val message : String?= null,
    val data : SignUpData? = null,
    val isLoading : Boolean = false
)
