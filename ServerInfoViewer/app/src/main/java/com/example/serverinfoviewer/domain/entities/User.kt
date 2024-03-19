package com.example.serverinfoviewer.domain.entities

import java.io.Serializable

data class User(
    var name: String = "",
    var userName: String = "",
    var email: String = "",
    var address: Address = Address(),
    var phone: String = "",
    var website: String = "",
    var company: Company = Company(),
    val id: Int = UNDEFINED_ID
): Serializable {
    companion object {
        const val UNDEFINED_ID = 0
    }
}