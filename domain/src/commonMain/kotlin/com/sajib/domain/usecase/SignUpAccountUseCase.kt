package com.sajib.domain.usecase

import com.sajib.domain.model.UserData
import com.sajib.domain.repository.UserRepository

class SignUpAccountUseCase constructor(val userRepository: UserRepository) {

    suspend fun signUpAccount(name : String, registerBy : String, emailOrPhone : String, password : String, confirmPassword : String) : Result<UserData>{
        return userRepository.signUpAccount(name = name,
            registerBy = registerBy,
            emailOrPhone = emailOrPhone,
            password = password,
            confirmPassword = confirmPassword)
    }
}