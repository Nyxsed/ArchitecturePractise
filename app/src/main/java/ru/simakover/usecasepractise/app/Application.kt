package ru.simakover.usecasepractise.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.simakover.usecasepractise.di.appModule
import ru.simakover.usecasepractise.di.dataModule
import ru.simakover.usecasepractise.di.domainModule

class Application: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@Application)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }

}