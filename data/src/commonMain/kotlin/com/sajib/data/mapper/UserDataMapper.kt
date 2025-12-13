package com.sajib.data.mapper

import com.sajib.data.model.SignUpResponse
import com.sajib.domain.model.UserData

object UserDataMapper {

    fun toUserData(signUpResponse: SignUpResponse) : UserData{
        return UserData(
            token = signUpResponse.access_token ?: "",
            emailAddress = signUpResponse.user?.email ?: "",
            userID = signUpResponse.user?.id ?: 0,
            name = signUpResponse.user?.name ?: "",
            phone = signUpResponse.user?.phone?: "",
            avatar = signUpResponse.user?.avatar?: "",
            avatar_original = signUpResponse.user?.avatar_original?: "",
            message = signUpResponse.message
        )
    }
}