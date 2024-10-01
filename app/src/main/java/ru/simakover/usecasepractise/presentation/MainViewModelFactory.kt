package ru.simakover.usecasepractise.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.simakover.usecasepractise.data.repository.UserRepositoryImpl
import ru.simakover.usecasepractise.data.storage.SharedPrefUserStorage
import ru.simakover.usecasepractise.domain.usecase.GetUserUseCase
import ru.simakover.usecasepractise.domain.usecase.SaveUserUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userStorage by lazy { SharedPrefUserStorage(context = context) }
    private val userRepository by lazy { UserRepositoryImpl(userStorage) }
    private val getUserUseCase by lazy { GetUserUseCase(userRepository) }
    private val saveUserUseCase by lazy { SaveUserUseCase(userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserUseCase = getUserUseCase,
            saveUserUseCase = saveUserUseCase
        ) as T
    }
}