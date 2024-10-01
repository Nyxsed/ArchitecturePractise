package ru.simakover.usecasepractise.data.storage

import ru.simakover.usecasepractise.data.models.UserPref

interface UserStorage {

    fun saveUser(user: UserPref)
    fun getUser(): UserPref
}