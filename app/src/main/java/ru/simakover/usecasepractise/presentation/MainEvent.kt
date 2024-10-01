package ru.simakover.usecasepractise.presentation

interface MainEvent

class SaveUserEvent(val firstName: String, val lastName: String) : MainEvent
class LoadUserEvent() : MainEvent
class BackToOldUserEvent(): MainEvent