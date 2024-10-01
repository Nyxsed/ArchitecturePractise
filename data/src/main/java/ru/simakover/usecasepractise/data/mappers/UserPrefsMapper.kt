package ru.simakover.usecasepractise.data.mappers

import ru.simakover.usecasepractise.data.models.UserPref
import ru.simakover.usecasepractise.domain.models.User

class UserPrefsMapper {
    fun mapUserToUserPrefs(user: User): UserPref {
        return UserPref(
            user.firstName,
            user.lastName
        )
    }

    fun mapUserPrefsToUser(userPref: UserPref): User {
        return User(
            userPref.firstName,
            userPref.lastName
        )
    }
}