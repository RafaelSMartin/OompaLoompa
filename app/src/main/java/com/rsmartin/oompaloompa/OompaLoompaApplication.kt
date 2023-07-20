package com.rsmartin.oompaloompa

import android.app.Application
import com.rsmartin.oompaloompa.di.dataModule
import com.rsmartin.oompaloompa.di.domainModule
import com.rsmartin.oompaloompa.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class OompaLoompaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@OompaLoompaApplication)
            modules(
                viewModelModule,
                domainModule,
                dataModule
            )
        }
    }

}