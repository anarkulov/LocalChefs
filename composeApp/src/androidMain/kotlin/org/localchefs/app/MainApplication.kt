package org.localchefs.app

import android.app.Application
import org.localchefs.app.shared.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.localchefs.app.shared.di.initKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        
        initKoin({
            androidLogger()
        })
    }
} 