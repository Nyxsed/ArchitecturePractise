package ru.simakover.usecasepractise.domain.repository

import ru.simakover.usecasepractise.domain.models.User

interface UserRepository {

    fun saveUser(user: User)
    fun getUser(): User
}