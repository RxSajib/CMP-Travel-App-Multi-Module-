package com.sajib.data.datasources

import com.sajib.data.model.CategoryDto
import com.sajib.data.model.SignUpResponse
import com.sajib.data.model.request.SignUpData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class RemoteDataSources(private val httpClient: HttpClient) {

    private val BASE_URL = "https://habibiyahabibi.com"
    private val SIGNIN_END_POINT = "${BASE_URL}/api/v2/auth/signup"
    private val CATEGORIES_END_POINT = "${BASE_URL}/api/v2/categories"


    suspend fun signUpAccount(signUpData: SignUpData) : Result<SignUpResponse> {
       return try {
            val response = httpClient.post(urlString = SIGNIN_END_POINT){
                setBody(signUpData)
            }
           Result.success(response.body())
        }catch (e : Exception){
           Result.failure(e)
        }
    }

    suspend fun getCategory() : Result<CategoryDto> {
        return try {
            val response = httpClient.get(urlString = CATEGORIES_END_POINT)
            Result.success(response.body())
        }catch (e : Exception){
            Result.failure(e)
        }
    }
}