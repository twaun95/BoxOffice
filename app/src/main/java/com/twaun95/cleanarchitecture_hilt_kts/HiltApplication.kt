package com.twaun95.cleanarchitecture_hilt_kts

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class HiltApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initLogger()
    }

    private fun initLogger() { Timber.plant(Timber.DebugTree()) }
}