package com.sajib.presentation.ui.signupScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sajib.domain.usecase.SignUpAccountUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel constructor(val signUpAccountUseCase: SignUpAccountUseCase) : ViewModel() {

    private val _signUpState = MutableStateFlow(SignUpState())
    val signUpState = _signUpState.asStateFlow()

    var nameInput by mutableStateOf("")
    val emailInput by mutableStateOf("")
    val passwordInput by mutableStateOf("")
    val confirmPasswordInput by mutableStateOf("")

    fun signUpAccount(name : String, emailAddress : String, password : String, confirmPassword : String){
        viewModelScope.launch {
         val response = signUpAccountUseCase.signUpAccount(name = name, emailOrPhone = emailAddress,
                password = password, confirmPassword = confirmPassword, registerBy = "email")
        }
    }
}