package com.example.serverinfoviewer.domain.entities

import java.io.Serializable

data class Address(
    var street: String = "",
    var suite: String = "",
    var city: String = "",
    var zipcode: String = "",
    var geo: GeoData = GeoData()
): Serializable