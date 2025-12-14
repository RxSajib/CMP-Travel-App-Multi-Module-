package com.sajib.presentation.ui.signupScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sajib.data.appConstant.AppConstant
import com.sajib.data.utils.ProgressDialogUtils
import com.sajib.domain.usecase.SignUpAccountUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel constructor(val signUpAccountUseCase: SignUpAccountUseCase) : ViewModel() {

    private val _signUpState = MutableStateFlow(SignUpState())
    val signUpState = _signUpState.asStateFlow()

    var nameInput by mutableStateOf("")
    var emailInput by mutableStateOf("")
    var passwordInput by mutableStateOf("")
    var confirmPasswordInput by mutableStateOf("")

    var isConfirmPasswordShows = mutableStateOf(false)
    var isPasswordShows = mutableStateOf(false)

    val isValidEmailAddress get() = AppConstant.emailRegex.matches(emailInput)


    fun signUpAccount() {
        viewModelScope.launch {
            ProgressDialogUtils.showDialog()
            val response = signUpAccountUseCase.signUpAccount(
                name = nameInput,
                emailOrPhone = emailInput,
                password = passwordInput,
                confirmPassword = confirmPasswordInput,
                registerBy = "email"
            )

            response.onSuccess { userData ->
                print("login success $userData")
            }.onFailure { error ->
                print("login error ${error.message}")
            }
            ProgressDialogUtils.disableDialog()
        }
    }

    val isSignUpButtonEnable
        get() = nameInput.isNotEmpty() && emailInput.isNotEmpty() && passwordInput.isNotEmpty() && confirmPasswordInput.isNotEmpty()
                && passwordInput.length >= 6 && passwordInput == confirmPasswordInput && isValidEmailAddress
}