package com.sajib.presentation.di

import com.sajib.domain.usecase.GetAllListingUseCase
import com.sajib.domain.usecase.GetCategoryUseCase
import com.sajib.domain.usecase.SignUpAccountUseCase
import com.sajib.presentation.listing.TravelListingViewModel
import com.sajib.presentation.ui.categoryScreen.CategoryViewModel
import com.sajib.presentation.ui.signInScreen.SignInViewModel
import com.sajib.presentation.ui.signupScreen.SignUpViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        TravelListingViewModel(getAllListingUseCase = get<GetAllListingUseCase>())

    }

    viewModel {
        SignInViewModel()
    }

    viewModel {
        SignUpViewModel(signUpAccountUseCase = get<SignUpAccountUseCase>())
    }

    viewModel {
        CategoryViewModel(categoryUseCase = get<GetCategoryUseCase>())
    }
}