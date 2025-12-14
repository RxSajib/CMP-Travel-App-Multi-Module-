package com.sajib.data.repository

import com.sajib.data.datasources.RemoteDataSources
import com.sajib.data.mapper.UserDataMapper
import com.sajib.data.model.request.SignUpData
import com.sajib.domain.model.UserData
import com.sajib.domain.repository.UserRepository

class UserRepositoryImpl (val remoteDataSources: RemoteDataSources) : UserRepository {

    override suspend fun signUpAccount(
        name: String,
        registerBy: String,
        emailOrPhone: String,
        password: String,
        confirmPassword: String
    ): Result<UserData> {
        return try {
            val response = remoteDataSources.signUpAccount(
                signUpData = SignUpData(
                    name = name,
                    register_by = registerBy,
                    email_or_phone = emailOrPhone,
                    password = password,
                    password_confirmation = confirmPassword
                )
            )
            if(response.isSuccess){
                val user = UserDataMapper.toUserData(response.getOrNull()!!)
                Result.success(user)
            }else {
                Result.failure(Exception("Error login account"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}