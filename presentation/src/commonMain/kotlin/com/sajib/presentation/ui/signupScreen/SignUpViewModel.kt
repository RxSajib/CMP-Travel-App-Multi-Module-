package com.sajib.presentation.ui.signupScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sajib.domain.usecase.SignUpAccountUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignUpViewModel constructor() : ViewModel() {

    private val _signUpState = MutableStateFlow(SignUpState())
    val signUpState = _signUpState.asStateFlow()

    var nameInput by mutableStateOf("")
    val emailInput by mutableStateOf("")
    val passwordInput by mutableStateOf("")
    val confirmPasswordInput by mutableStateOf("")
}