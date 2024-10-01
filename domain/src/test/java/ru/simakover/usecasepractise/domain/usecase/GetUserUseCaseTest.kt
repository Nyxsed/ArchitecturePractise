package ru.simakover.usecasepractise.domain.usecase

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import ru.simakover.usecasepractise.domain.models.User
import ru.simakover.usecasepractise.domain.repository.UserRepository

class GetUserUseCaseTest {

    // test repo with mock lib
    private val userRepository = mock<UserRepository>()

    @AfterEach
    fun tearDown(){
        Mockito.reset(userRepository)
    }

    @Test
    fun `should return the same data as in repository`() {

        // as someone run getUser return test user
        val testUser = User(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getUser()).thenReturn(testUser)

        // create use case and run it
        val useCase = GetUserUseCase(
            userRepository = userRepository
        )
        val actual = useCase.execute()
        val expected = User(firstName = "test first name", lastName = "test last name")

        // assert expected and actual values
        Assertions.assertEquals(expected, actual)
    }
}