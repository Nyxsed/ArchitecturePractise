package ru.simakover.usecasepractise.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.simakover.usecasepractise.presentation.MainViewModel

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(
            getUserUseCase = get(),
            saveUserUseCase = get(),
        )
    }
}