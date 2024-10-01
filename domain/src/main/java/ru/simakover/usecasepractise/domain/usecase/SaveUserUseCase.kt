package ru.simakover.usecasepractise.domain.usecase

import ru.simakover.usecasepractise.domain.models.User
import ru.simakover.usecasepractise.domain.repository.UserRepository

class SaveUserUseCase(
    private val userRepository: UserRepository
) {

    fun execute(user: User) {

        val oldUser = userRepository.getUser()

        if (oldUser !== user) {
            val result = userRepository.saveUser(user)
        }
    }
}