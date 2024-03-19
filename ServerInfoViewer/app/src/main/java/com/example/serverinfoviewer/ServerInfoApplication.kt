package com.example.serverinfoviewer

import android.app.Application
import com.example.serverinfoviewer.di.DaggerApplicationComponent

class ServerInfoApplication: Application() {
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}