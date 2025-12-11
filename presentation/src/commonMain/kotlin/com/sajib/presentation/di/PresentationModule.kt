package com.sajib.presentation.di

import com.sajib.domain.usecase.GetAllListingUseCase
import com.sajib.presentation.listing.TravelListingViewModel
import com.sajib.presentation.signInScreen.SignInViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        TravelListingViewModel(getAllListingUseCase = get<GetAllListingUseCase>())

    }

    viewModel {
        SignInViewModel()
    }
}