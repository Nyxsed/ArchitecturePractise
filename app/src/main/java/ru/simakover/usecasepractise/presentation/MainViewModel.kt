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

    private val _userLiveData = MutableLiveData<User>()
    val userLiveData: LiveData<User> = _userLiveData


    fun saveUser(firstName: String, lastName: String) {
        val user = User(firstName, lastName)
        saveUserUseCase.execute(user)
    }

    fun loadUser() {
        _userLiveData.value = getUserUseCase.execute()
    }
}