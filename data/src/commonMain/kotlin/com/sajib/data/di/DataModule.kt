package com.sajib.data.di

import com.sajib.data.datasources.DummyDataSource
import com.sajib.data.repository.TravelingListingImpl
import com.sajib.domain.repository.ListingRepository
import org.koin.dsl.module

val dataModule = module{
   single {
       DummyDataSource()
   }

    single<ListingRepository> {
        TravelingListingImpl(dataSource = get())
    }
}