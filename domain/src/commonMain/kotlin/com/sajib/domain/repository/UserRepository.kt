package com.sajib.domain.repository

import com.sajib.domain.model.UserData

interface UserRepository {
    suspend fun signUpAccount(name : String, registerBy : String, emailOrPhone : String, password : String, confirmPassword : String) : Result<UserData>
}