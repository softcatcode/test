package com.example.serverinfoviewer.domain.interfaces

import com.example.serverinfoviewer.domain.entities.User

interface GetDataInterface {
    fun getUserList(): List<User>
}