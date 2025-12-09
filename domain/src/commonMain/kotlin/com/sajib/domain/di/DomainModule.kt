package com.sajib.domain.di

import com.sajib.domain.repository.ListingRepository
import com.sajib.domain.usecase.GetAllListingUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        GetAllListingUseCase(listingRepository = get<ListingRepository>())
    }
}