package com.sajib.presentation.ui.signInScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sajib.data.appConstant.AppConstant

class SignInViewModel : ViewModel() {

    var inputEmailAddressInput by mutableStateOf("")

    var passwordInput by mutableStateOf("")
    var isPasswordVisible by mutableStateOf(false)

    var isValidEmailAddress by mutableStateOf(false)

    fun onEmailChanged(inputEmailAddressInput: String) {
        val valid = AppConstant.emailRegex.matches(inputEmailAddressInput)
        isValidEmailAddress = valid
    }

    val isButtonEnableForSignIn: Boolean
        get() = isValidEmailAddress && passwordInput.isNotEmpty() && passwordInput.length >= 6

}