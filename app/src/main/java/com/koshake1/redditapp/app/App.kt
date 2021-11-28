package com.koshake1.redditapp.app

import android.app.Application
import com.koshake1.redditapp.di.dataSourceModule
import com.koshake1.redditapp.di.repositoryModule
import com.koshake1.redditapp.di.retrofitModule
import com.koshake1.redditapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            loadKoinModules(
                listOf(
                    retrofitModule,
                    dataSourceModule,
                    repositoryModule,
                    viewModelModule,
                )
            )
        }
    }
}