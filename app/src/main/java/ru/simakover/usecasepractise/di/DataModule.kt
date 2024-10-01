package ru.simakover.usecasepractise.di

import org.koin.dsl.module
import ru.simakover.usecasepractise.data.repository.UserRepositoryImpl
import ru.simakover.usecasepractise.data.storage.SharedPrefUserStorage
import ru.simakover.usecasepractise.data.storage.UserStorage
import ru.simakover.usecasepractise.domain.repository.UserRepository

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}