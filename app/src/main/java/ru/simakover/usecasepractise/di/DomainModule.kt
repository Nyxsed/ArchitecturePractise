package ru.simakover.usecasepractise.di

import org.koin.dsl.module
import ru.simakover.usecasepractise.domain.usecase.GetUserUseCase
import ru.simakover.usecasepractise.domain.usecase.SaveUserUseCase

val domainModule = module {

    factory<GetUserUseCase> {
        GetUserUseCase(userRepository = get())
    }

    factory<SaveUserUseCase> {
        SaveUserUseCase(userRepository = get())
    }

}