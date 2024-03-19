package com.example.serverinfoviewer.domain.entities

import java.io.Serializable

data class GeoData(
    var lat: Double = 0.0,
    var lng: Double = 0.0
): Serializable