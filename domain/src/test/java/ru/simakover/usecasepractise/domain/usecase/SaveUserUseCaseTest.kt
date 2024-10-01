package ru.simakover.usecasepractise.domain.usecase

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import ru.simakover.usecasepractise.domain.models.User
import ru.simakover.usecasepractise.domain.repository.UserRepository

class SaveUserUseCaseTest {

    private val userRepository = mock<UserRepository>()
    private val useCase = SaveUserUseCase(userRepository = userRepository)
    private val savedUser = User(firstName = "saved first name", lastName = "saved last name")

    @AfterEach
    fun tearDown(){
        Mockito.reset(userRepository)
    }

    @Test
    fun `should not save data if user already saved`() {
        Mockito.`when`(userRepository.getUser()).thenReturn(savedUser)
        val testUser = User(firstName = "saved first name", lastName = "saved last name")
        useCase.execute(testUser)

        Mockito.verify(userRepository, Mockito.never()).saveUser(user = any())
    }

    @Test
    fun `should save data if new user added`() {
        Mockito.`when`(userRepository.getUser()).thenReturn(savedUser)
        val testUser = User(firstName = "new first name", lastName = "new last name")
        useCase.execute(testUser)

        Mockito.verify(userRepository, Mockito.times(1)).saveUser(user = testUser)
    }

}