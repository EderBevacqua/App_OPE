package com.example.andre.monteiro.controlloan

import android.app.Application
import java.lang.IllegalStateException

class ControlloanApplication: Application() {

    override fun onCreate(){
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: ControlloanApplication? = null
        fun getInstance(): ControlloanApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configurar Application no Android Manifest")
            }
            return appInstance!!
        }
    }
    override fun onTerminate() {
        super.onTerminate()
    }

}