package com.example.serverinfoviewer.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.serverinfoviewer.domain.entities.User
import com.example.serverinfoviewer.presentation.ui.compose.UserInfoWindow

class UserInfoActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserInfoWindow(intent?.getSerializableExtra(USER_KEY) as User)
        }
    }

    companion object {
        const val USER_KEY = "user_key"
    }
}