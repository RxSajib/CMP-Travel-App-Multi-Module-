package com.sajib.data.di

import com.sajib.data.datasources.DummyDataSource
import com.sajib.data.datasources.RemoteDataSources
import com.sajib.data.repository.TravelingListingImpl
import com.sajib.data.repository.UserRepositoryImpl
import com.sajib.domain.repository.ListingRepository
import com.sajib.domain.repository.UserRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module


val dataModule = module{
   single {
       DummyDataSource()
   }

    single<ListingRepository> {
        TravelingListingImpl(dataSource = get())
    }

    single {
        HttpClient{
            install(ContentNegotiation){
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    encodeDefaults = false
                    prettyPrint = true
                })
            }
            install(Logging){
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
            install(DefaultRequest){
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }
        }
    }

    single {
        RemoteDataSources(
            httpClient = get()
        )
    }

    single<UserRepository> {
        UserRepositoryImpl(remoteDataSources = get())
    }
}