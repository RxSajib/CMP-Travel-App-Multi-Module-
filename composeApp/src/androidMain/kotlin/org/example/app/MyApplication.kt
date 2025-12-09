package org.example.app

import android.app.Application
import org.example.project.di.initKoin
import org.example.project.di.listOfModule

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            modules(listOfModule)
        }
        multiplatform.network.cmptoast.AppContext.apply { set(applicationContext) }


    }
}