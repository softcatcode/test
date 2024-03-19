package com.example.serverinfoviewer.domain.entities

data class Address(
    var street: String = "",
    var suit: String = "",
    var city: String = "",
    var zipcode: String = "",
    var geo: GeoData = GeoData()
)