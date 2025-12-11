package com.sajib.presentation.signInScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel() {

    var inputEmailAddressInput by mutableStateOf("")

    var passwordInput by mutableStateOf("")
    var isPasswordVisible by mutableStateOf(false)
}