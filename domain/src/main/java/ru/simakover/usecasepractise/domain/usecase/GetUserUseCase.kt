package ru.simakover.usecasepractise.domain.usecase

import ru.simakover.usecasepractise.domain.models.User
import ru.simakover.usecasepractise.domain.repository.UserRepository

class GetUserUseCase(
    private val userRepository: UserRepository
) {

    fun execute(): User {
        val user = userRepository.getUser()
        return user
    }
}