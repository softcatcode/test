package com.example.serverinfoviewer.presentation.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.serverinfoviewer.domain.entities.User

@Composable
@Preview(showBackground = true)
fun UserInfoWindow(user: User = User()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(user.id.toString())
        Text(user.userName)
        Text(user.name)
        Text(user.phone)
        Text(user.email)
        Text(user.website)
    }
}