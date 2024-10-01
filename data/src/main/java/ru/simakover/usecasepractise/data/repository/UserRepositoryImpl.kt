package ru.simakover.usecasepractise.data.repository

import ru.simakover.usecasepractise.data.mappers.UserPrefsMapper
import ru.simakover.usecasepractise.data.storage.UserStorage
import ru.simakover.usecasepractise.domain.models.User
import ru.simakover.usecasepractise.domain.repository.UserRepository


class UserRepositoryImpl(
    private val userStorage: UserStorage,
) : UserRepository {

    private val mapper = UserPrefsMapper()

    override fun saveUser(
        user: User,
    ) {
        val userPref = mapper.mapUserToUserPrefs(user)

        return userStorage.saveUser(userPref)
    }

    override fun getUser(): User {
        val userPref = userStorage.getUser()
        val user = mapper.mapUserPrefsToUser(userPref)

        return user
    }
}