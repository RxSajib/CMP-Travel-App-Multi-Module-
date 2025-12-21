package com.sajib.presentation.ui.signupScreen

import com.sajib.data.model.request.SignUpData
import com.sajib.domain.model.UserData

data class SignUpState(
    val message : String?= null,
    val data : UserData? = null,
    val isLoading : Boolean = false
)
