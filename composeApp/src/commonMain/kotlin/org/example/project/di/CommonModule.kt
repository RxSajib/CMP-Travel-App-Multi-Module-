package org.example.project.di

import com.sajib.data.di.dataModule
import com.sajib.domain.di.domainModule
import com.sajib.presentation.di.presentationModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val listOfModule = listOf(
    dataModule,
    domainModule,
    presentationModule
)


fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(listOfModule)
    }
}