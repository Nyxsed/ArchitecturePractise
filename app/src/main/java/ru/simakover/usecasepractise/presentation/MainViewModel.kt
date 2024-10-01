package ru.simakover.usecasepractise.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.simakover.usecasepractise.domain.models.User
import ru.simakover.usecasepractise.domain.usecase.GetUserUseCase
import ru.simakover.usecasepractise.domain.usecase.SaveUserUseCase

class MainViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val saveUserUseCase: SaveUserUseCase,
) : ViewModel() {

    // выход
    private val _stateLiveData = MutableLiveData<MainState>()
    val stateLiveData: LiveData<MainState> = _stateLiveData

    private val _oldStateLiveData = MutableLiveData<MainState>()

    // вход
    fun send(event: MainEvent) {
        when (event) {
            is SaveUserEvent -> {
                saveUser(event.firstName, event.lastName)
            }

            is LoadUserEvent -> {
                loadUser()
            }

            is BackToOldUserEvent -> {
                backToOldState()
            }
        }

    }

    init {
        _stateLiveData.value = MainState(
            firstName = "",
            lastName = ""
        )
        _oldStateLiveData.value = _stateLiveData.value
    }

    private fun saveUser(firstName: String, lastName: String) {
        val user = User(firstName, lastName)
        saveUserUseCase.execute(user)
        _oldStateLiveData.value = _stateLiveData.value
    }

    private fun loadUser() {
        val user = getUserUseCase.execute()
        _stateLiveData.value = MainState(
            firstName = user.firstName,
            lastName = user.lastName
        )
    }

    private fun backToOldState() {
        _stateLiveData.value = _oldStateLiveData.value
    }
}