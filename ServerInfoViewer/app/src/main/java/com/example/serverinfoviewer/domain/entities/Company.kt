package com.example.serverinfoviewer.domain.entities

import java.io.Serializable

data class Company(
    var name: String = "",
    var catchPhrase: String = "",
    var bs: String = ""
): Serializable