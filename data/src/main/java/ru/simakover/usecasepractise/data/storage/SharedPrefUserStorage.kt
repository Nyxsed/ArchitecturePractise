package ru.simakover.usecasepractise.data.storage

import android.content.Context
import ru.simakover.usecasepractise.data.models.UserPref

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val FIRST_NAME = "firstName"
private const val LAST_NAME = "lastName"

class SharedPrefUserStorage(
    private val context: Context,
) : UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveUser(user: UserPref) {
        sharedPreferences.edit().putString(FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(LAST_NAME, user.lastName).apply()
    }

    override fun getUser(): UserPref {
        val firstName = sharedPreferences.getString(FIRST_NAME, "") ?: ""
        val lastName = sharedPreferences.getString(LAST_NAME, "") ?: ""

        return UserPref(
            firstName = firstName,
            lastName = lastName
        )
    }
}