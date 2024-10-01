package ru.simakover.usecasepractise.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito
import org.mockito.kotlin.mock
import ru.simakover.usecasepractise.domain.models.User
import ru.simakover.usecasepractise.domain.usecase.GetUserUseCase
import ru.simakover.usecasepractise.domain.usecase.SaveUserUseCase

class MainViewModelTest {

    private val getUserUseCase = mock<GetUserUseCase>()
    private val saveUserUseCase = mock<SaveUserUseCase>()
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    // clear repos between test
    @AfterEach
    fun afterEach() {
        Mockito.reset(getUserUseCase)
        Mockito.reset(saveUserUseCase)
    }

    @BeforeEach
    fun beforeEach() {

    }

    @Test
    fun `should save user`() {

        val oldUser = User(firstName = "old first name", lastName = "old last name")
        val newUser = User(firstName = "new first name", lastName = "new last name")

        Mockito.`when`(getUserUseCase.execute()).thenReturn(oldUser)

        viewModel = MainViewModel(
            getUserUseCase = getUserUseCase,
            saveUserUseCase = saveUserUseCase,
        )
        viewModel.send(SaveUserEvent(newUser.firstName, newUser.lastName))

        val actual = viewModel.stateLiveData.value
        val expected = MainState (
            firstName = "new first name",
            lastName = "new first name"
        )
        Assertions.assertEquals(expected, actual)
        Mockito.verify(saveUserUseCase, Mockito.times(1)).execute(user = newUser)
    }

    @Test
    fun `should not save user`() {

        val oldUser = User(firstName = "old first name", lastName = "old last name")
        val newUser = User(firstName = "old first name", lastName = "old last name")

        Mockito.`when`(getUserUseCase.execute()).thenReturn(oldUser)

        viewModel = MainViewModel(
            getUserUseCase = getUserUseCase,
            saveUserUseCase = saveUserUseCase,
        )
        viewModel.send(SaveUserEvent(newUser.firstName, newUser.lastName))

        val actual = viewModel.stateLiveData.value
        val expected = MainState (
            firstName = "old first name",
            lastName = "old first name"
        )
        Assertions.assertEquals(expected, actual)
        Mockito.verify(saveUserUseCase, Mockito.times(1)).execute(user = newUser)
    }

    @Test
    fun `should load user`() {

        val oldUser = User(firstName = "old first name", lastName = "old last name")
        Mockito.`when`(getUserUseCase.execute()).thenReturn(oldUser)

        viewModel = MainViewModel(
            getUserUseCase = getUserUseCase,
            saveUserUseCase = saveUserUseCase,
        )
        viewModel.send(LoadUserEvent())

        val actual = viewModel.stateLiveData.value
        val expected = MainState (
            firstName = "old first name",
            lastName = "old last name"
        )
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `should back to old user`() {
        TODO()
    }
}